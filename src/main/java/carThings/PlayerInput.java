package carThings;

import helpers.Vector2;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerInput {

    private final Set<KeyCode> keys;

    public PlayerInput(Set<KeyCode> keys) {
        this.keys = keys;
        playerInputSetup();
    }

    public boolean accelerate() {return keys.contains(accelChar);}
    public boolean brake() {return keys.contains(breakChar);}
    public boolean left;
    public boolean right;
    public boolean handBrake() {return  keys.contains(handBrakeChar);}

    public void inputUpdate() {
        steering();
    }


    public int steering() {
        List<KeyCode> keyCodes = new ArrayList<>(keys);
        System.out.println(keyCodes);
        for(int i = keyCodes.size()-1; i >= 0; i--) {
            if (keyCodes.get(i).equals(goLeftChar)) {
                left = true;
                right = false;
                return -1;
            }
            if (keyCodes.get(i).equals(goRightChar)) {
                right = true;
                left = false;
                return 1;
            }
        }
        return 0;
}

    KeyCode accelChar;
    KeyCode breakChar;
    KeyCode goLeftChar;
    KeyCode goRightChar;
    KeyCode handBrakeChar;



    void playerInputSetup() {
        accelChar = KeyCode.W;
        breakChar = KeyCode.S;
        goLeftChar = KeyCode.A;
        goRightChar = KeyCode.D;
        handBrakeChar = KeyCode.SPACE;
    }



}
