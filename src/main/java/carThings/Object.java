package carThings;

import Helpers.Vector2;

public class Object {
    public Object(double x, double y) {
        this.position.x = x;
        this.position.y = y;
    }

    Vector2 position;
    float globalRotation;

    void move(Vector2 vector2) {
        position.add(vector2);
    }

    void update(){

    }

    void rotate(float degrees) {
        globalRotation += degrees;
        if (globalRotation >= 360) {
            globalRotation -= 360;
        }
        else if (globalRotation < 0) {
            globalRotation += 360;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
