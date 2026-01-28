package carThings;

import fxComponents.AssetManager;
import helpers.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class Car extends GameObject {

    //connectors
    PlayerInput input;

    //Unit: Pixel per Second (PPS)
    private double turnSpeed = 0;

    //Unit: percent
    private double traction = 1;

    //Unit: Degrees
    private double rotation = 0;
    //Unit: px/s²
    private static final double ACCEL = 200;

    //Unit: px/s
    private static final double MAX_SPEED = 1000;

    //Unit: dgr/s (degrees per second)
    private static final double TURN_ACCEL = 0.5; //was 180
    private static final double MIN_TURN_SPEED = 100;

    //unitless
    private static final double DRAG = 0.995;

    //starting with vectors
    //Vector for forward force
    public Vector2 velocity = new Vector2(0, 0);

    //Vector for sideway force
    public Vector2 lateralForce;

    //Vector for pointing direction
    public Vector2 forward = new Vector2(0, -1);

    public Car(double x, double y) {
        super(x, y);
    }

    public void update(double dt, PlayerInput _input) {
        this.input = _input;
        steeringCalc(dt);
        if (input.handBrake()) {
            traction = 0.05;
        } else {
            //should be changed in the future if there are more sources to change the traction
            traction = 0.25;
        }

        if (input.accelerate()) {
            Vector2 accelerationForce = new Vector2(
                    forward.x * ACCEL,
                    forward.y * ACCEL
            );
            System.out.println("Beschleunigen: " + accelerationForce);
            velocity.add(accelerationForce.multiplyAndReturn(dt));
        }
        if (input.brake()) {
            Vector2 accelerationForce = new Vector2(
                    forward.x * -ACCEL,
                    forward.y * -ACCEL
            );
            System.out.println("Bremsen: " + accelerationForce);
            velocity.add(accelerationForce.multiplyAndReturn(dt));
        }
        //just add drag when we are not accelerating or braking
        if (!(input.accelerate() || input.brake())) {
            velocity.multiply(DRAG);
        }

        //limit speed
        if (velocity.magnitude() >= MAX_SPEED) {
            velocity.setToLength(MAX_SPEED);
        }

        //at which speed the car completely halts
        int zeroVelThreshold = 10;
        if (velocity.magnitude() <= zeroVelThreshold && !(input.accelerate() || input.brake())) {
            velocity = new Vector2(0, 0);
        }

        position.add(velocity.multiplyAndReturn(dt));
    }

    private void steeringCalc(double dt) {
        int steering = input.steering();
        double speed = velocity.magnitude();


        //steering
        if (velocity.magnitude() != 0) {
            //should be changed
            double turnRate = MIN_TURN_SPEED + (speed / MAX_SPEED) * TURN_ACCEL;
            if (input.handBrake()) {
                turnRate += 3; //maybe 1.5
            }
            rotation += steering * turnRate * dt;

            //update forward vector
            forward.x = Math.sin(Math.toRadians(rotation));
            forward.y = -Math.cos(Math.toRadians(rotation));
            //so it only shows direction and has no "force"
            forward.normalize();

            //side vector
            Vector2 right = new Vector2(-forward.y, forward.x);

            //split velocity
            double forwardSpeed = velocity.x * forward.x + velocity.y * forward.y;
            double lateralSpeed = velocity.x * right.x + velocity.y * right.y;

            //apply grip
            double speedFactor = Math.min(speed / MAX_SPEED, 1.0);
            double effectiveGrip = traction * speedFactor;
            lateralSpeed *= (1.0 - effectiveGrip);
            System.out.println("Grip: " + effectiveGrip);

            //rebuild velocity
            velocity.x = forward.x * forwardSpeed + right.x * lateralSpeed;
            velocity.y = forward.y * forwardSpeed + right.y * lateralSpeed;
        }
    }


    public void draw(GraphicsContext gc) {
        gc.save();
        gc.translate(position.x, position.y);
        gc.rotate(rotation);
        gc.drawImage(AssetManager.CAR_RED, -10, -23, 20, 45);
        gc.restore();

        //debug for showing car coordinates
//        System.out.println("X: " + position.x + " Y: " + position.y);
        System.out.println("Geschwindigkeit: " + velocity.magnitude());
        System.out.println("Velocity Vektor: " + velocity);
    }
}
