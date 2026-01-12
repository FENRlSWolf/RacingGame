import Helpers.Vector2;
import java.awt.event.KeyListener;

public class Car extends Object{
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


    /**
     * returns a MovementVector2 that is local to the cars rotation, thus the rotation has to somehow be account to
     * @return Vector2
     */
    Vector2 calcShortTermMovementVector2() {
        Vector2 shortTermMovementVector = new Vector2(0, 0);
        //do calculation here





        //drag
        shortTermMovementVector.x -= (shortTermMovementVector.x * dragInPercent);

        return shortTermMovementVector;
    }

}
