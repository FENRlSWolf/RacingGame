package carThings;

import fxComponents.AssetManager;
import javafx.scene.canvas.GraphicsContext;

public class Car extends GameObject {
    //Linecoment just for testing

    /*
    //stats editable
    double power; //influences acceleration
    double handlingStat; //influences cornerperformance
    double weight; //influences breakingPower, traction, acceleration
    double breakingPower;




    //stats that are based on other stats
    double accelStat;
    double traction;

    //other stats
    double dragInPercent = 5;



    //others
    PlayerInput playerInput = new PlayerInput();


    Vector2 movementVector;

    public Car(double x, double y) {
        super(x, y);
    }

    @Override
   public void update() {
        super.update();
        move(movementVector);
    }
    */

    /**
     * returns a MovementVector2 that is local to the cars rotation, thus the rotation has to somehow be account to
     * @return Vector2
     */
    /*
    Vector2 localTermMovementVector2() {
        Vector2 localMovementVector = new Vector2(0, 0);
        //do calculation here





        //drag
        localMovementVector.x -= (localMovementVector.x * dragInPercent);
        if (localMovementVector.y <= 0) {
            localMovementVector.x = 0;
        }



        if (playerInput.isHandBreaking()) {
            //decrease traction and slow down


        }
        if(playerInput.isAccelerating()) {
            localMovementVector.y += accelStat; //later add framedeltatime and traction
        }
        if (playerInput.isBreaking()) {
            localMovementVector.y -= breakingPower; //later add framedeltatime and traction
        }
        if (playerInput.isGoingLeft()) {
            localMovementVector.x -= handlingStat; //later add framedeltatime and traction
        }
        if (playerInput.isGoingRight()) {
            localMovementVector.x += handlingStat; //later add framedeltatime and traction
        }




        return localMovementVector;
    }



    public void draw(GraphicsContext gc) {
        //gc.drawImage(carImage, position.x, position.y);
    }
  */

    //connectors
    PlayerInput input;


    //Unit: Pixel per Second (PPS)
    private double speed = 0;
    private double turnSpeed = 0;

    //Unit: percent
    private double traction = 1;

    //Unit: Degrees
    private double rotation = 0;
    private double moveDirection = 0;
    //Unit: px/s²
    private static final double ACCEL = 200;

    //Unit: px/s
    private static final double MAX_SPEED = 400;

    //Unit: dgr/s (degrees per second)
    private static final double TURN_ACCEL = 30; //was 180
    private static final double MAX_TURN_SPEED = 200;

    //unitless
    private static final double DRAG = 0.98;

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
        if (input.accelerate()) speed += ACCEL * dt;
        if (input.brake()) speed -= ACCEL *dt;




        //speed limitation
        speed = Math.max(-MAX_SPEED, Math.min(MAX_SPEED, speed));
        speed *= DRAG;
        int zeroVelThreshold = 10;
        if(speed <= zeroVelThreshold && speed >= -zeroVelThreshold && !(input.accelerate() || input.brake())) {
            speed = 0;
        }



        double rad = Math.toRadians(moveDirection);

        position.x += Math.sin(rad) * speed * dt;
        position.y -= Math.cos(rad) * speed *dt;
    }

    private void steeringCalc(double dt) {
        int steering = input.steering();
        System.out.println(steering);

        if(steering != 0) {
            //car is turning
            turnSpeed += TURN_ACCEL * speed/MAX_SPEED;
            if(turnSpeed > MAX_TURN_SPEED) {
                turnSpeed = MAX_TURN_SPEED;
            }
        } else {
            turnSpeed = 0;
        }
        if (speed != 0) {
            //car orientation
            if (steering == -1) {
                rotation -= turnSpeed * dt;
                moveDirection -= turnSpeed * dt * traction;
            }
            if (steering == 1) {
                rotation += turnSpeed * dt;
                moveDirection = rotation + (turnSpeed * dt * traction);
            }

        }
    }


    public void draw(GraphicsContext gc){
        gc.save();
        gc.translate(position.x,  position.y);
        gc.rotate(rotation);
        gc.drawImage(AssetManager.CAR_RED, -10, -23, 20, 45);
        gc.restore();
    }
}
