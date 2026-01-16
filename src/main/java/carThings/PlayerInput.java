package carThings;

import helpers.Vector2;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class PlayerInput {

    private final Set<KeyCode> keys;

    public PlayerInput(Set<KeyCode> keys) {
        this.keys = keys;
        playerInputSetup();
    }

    public boolean accelerate() {return keys.contains(accelChar);}
    public boolean brake() {return keys.contains(breakChar);}
    public boolean left() {return  keys.contains(goLeftChar);}
    public boolean right() {return  keys.contains(goRightChar);}
    public boolean handBrake() {return  keys.contains(handBrakeChar);}



    KeyCode accelChar;
    KeyCode breakChar;
    KeyCode goLeftChar;
    KeyCode goRightChar;
    KeyCode handBrakeChar;


    private Vector2 inputVector = new Vector2(0,0);

    void playerInputSetup() {
        accelChar = KeyCode.W;
        breakChar = KeyCode.S;
        goLeftChar = KeyCode.A;
        goRightChar = KeyCode.D;
        handBrakeChar = KeyCode.SPACE;
    }



    void calcInputVector() {
        if (handBrake()) {
            //decrease traction and slow down


        }
        if(accelerate()) {
            inputVector.y = 1; //later add framedeltatime and traction
        }
        if (brake()) {
            inputVector.y = -1; //later add framedeltatime and traction
        }
        if (left()) {
            inputVector.x = -1; //later add framedeltatime and traction
        }
        if (right()) {
            inputVector.x = 1; //later add framedeltatime and traction
        }


        System.out.println(inputVector);
    }



    public Vector2 getInputVector() {
        return inputVector;
    }

}
