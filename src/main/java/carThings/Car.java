package carThings;

import Helpers.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class Car extends Object {
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
    void update() {
        super.update();
        move(movementVector);
    }

    /**
     * returns a MovementVector2 that is local to the cars rotation, thus the rotation has to somehow be account to
     * @return Vector2
     */
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
        gc.drawImage(carImage, position.x, position.y);
    }
}
