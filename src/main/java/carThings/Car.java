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
    private static final double ACCEL = 3;

    //Unit: px/s
    private static final double MAX_SPEED = 30;

    //Unit: dgr/s (degrees per second)
    private static final double TURN_ACCEL = 0.005; //was 180
    private static final double MIN_TURN_SPEED = 80;

    //unitless
    private static final double DRAG = 0.995;

    //starting with vectors
    //Vector for forward force
    public Vector2 velocity = new Vector2(0,0);

    //Vector for sideway force
    public Vector2 lateralForce;

    //Vector for pointing direction
    public Vector2 forward = new Vector2(0,-1);

    public Car(double x, double y){
        super(x, y);
    }
    public void update(double dt, PlayerInput _input) {
        this.input = _input;
        steeringCalc(dt);
        if (input.handBrake()) traction -= 0.5;
        else {
            //should be changed in the future if there are more sources to change the traction
            traction = 1;
        }
        if (input.accelerate()) {
            Vector2 accelerationForce = new Vector2(
                    forward.x * ACCEL,
                    forward.y * ACCEL
            );
            velocity.add(accelerationForce.multiplyAndReturn(dt));
        }
        if (input.brake()) {
            Vector2 accelerationForce = new Vector2(
                    forward.x * ACCEL,
                    forward.y * ACCEL
            );
            velocity.subtract(accelerationForce.multiplyAndReturn(dt));
        }
        //just add drag when we are not accelerating or braking
        if(!(input.accelerate() || input.brake())){
            velocity.multiply(DRAG);
        }

        //limit speed
        if(velocity.magnitude() >= MAX_SPEED) {
            velocity.setToLength(MAX_SPEED);

            System.out.println("Geschwindigkeit: " + velocity.magnitude());
        }

        //at which speed the car completely halts
        int zeroVelThreshold = 2;
        if(velocity.magnitude() <= zeroVelThreshold && !(input.accelerate() || input.brake())) {
            velocity = new Vector2(0,0);
        }

        position.add(velocity);
    }

    private void steeringCalc(double dt) {
        int steering = input.steering();


        //steering
        if (velocity.magnitude() != 0) {
            //double steeringStrengh = (velocity.magnitude()/ MAX_SPEED);
            //steeringStrengh = Math.min(1, steeringStrengh) * 3.5;
            rotation += (MIN_TURN_SPEED +  TURN_ACCEL* velocity.magnitude()) * steering * dt; //  * steeringStrengh


            forward.x = Math.sin(Math.toRadians(rotation));
            forward.y = -Math.cos(Math.toRadians(rotation));

            //grip to 0.0001 for ice like driving
            double grip = 1;
            double speed = velocity.magnitude();

            velocity.x = velocity.x * (1 - grip) + forward.x * speed * grip;
            velocity.y = velocity.y * (1 - grip) + forward.y * speed * grip;
        }
    }


    public void draw(GraphicsContext gc){
        gc.save();
        gc.translate(position.x,  position.y);
        gc.rotate(rotation);
        gc.drawImage(AssetManager.CAR_RED, -10, -23, 20, 45);
        gc.restore();

        //debug for showing car coordinates
        System.out.println("X: " + position.x + " Y: " + position.y);
//        System.out.println("Geschwindigkeit: " + velocity.magnitude());
    }
}
