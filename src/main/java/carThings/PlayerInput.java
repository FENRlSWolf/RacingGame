package carThings;

import Helpers.Vector2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInput {
    char accelChar;
    char breakChar;
    char goLeftChar;
    char goRightChar;
    char handBreakChar;


    boolean accelerating = false;
    boolean breaking = false;
    boolean goingLeft = false;
    boolean goingRight = false;
    boolean handBreaking = false;

    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar() == accelChar) {
                accelerating = true;
            }
            if(e.getKeyChar() == breakChar) {
                breaking = true;
            }
            if(e.getKeyChar() == goLeftChar) {
                goingLeft = true;
            }
            if(e.getKeyChar() == goRightChar) {
                goingRight = true;
            }
            if(e.getKeyChar() == handBreakChar) {
                handBreaking = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() == accelChar) {
                accelerating = false;
            }
            if (e.getKeyChar() == breakChar) {
                breaking = false;
            }
            if (e.getKeyChar() == goLeftChar) {
                goingLeft = false;
            }
            if (e.getKeyChar() == goRightChar) {
                goingRight = false;
            }
            if (e.getKeyChar() == handBreakChar) {
                handBreaking = false;
            }
        }
    };

    public void playerInput() {
        playerInputSetup();
    }

    void playerInputSetup() {
        accelChar = 'w';
        breakChar = 'S';
        goLeftChar = 'A';
        goRightChar = 'D';
        handBreakChar = ' ';
    }

    void calcInputVector() {
        Vector2 inputVector = new Vector2(0 ,0);

        if (isHandBreaking()) {
            //decrease traction and slow down


        }
        if(isAccelerating()) {
            inputVector.y = 1; //later add framedeltatime and traction
        }
        if (isBreaking()) {
            inputVector.y = -1; //later add framedeltatime and traction
        }
        if (isGoingLeft()) {
            inputVector.x = -1; //later add framedeltatime and traction
        }
        if (isGoingRight()) {
            inputVector.x = 1; //later add framedeltatime and traction
        }

        inputVector.normalize();
        System.out.println(inputVector);
        System.out.println(isAccelerating());
    }




    public boolean isAccelerating() {
        return accelerating;
    }

    public boolean isBreaking() {
        return breaking;
    }

    public boolean isGoingLeft() {
        return goingLeft;
    }

    public boolean isGoingRight() {
        return goingRight;
    }

    public boolean isHandBreaking() {
        return handBreaking;
    }
}
