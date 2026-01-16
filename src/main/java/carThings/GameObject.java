package carThings;

import helpers.Vector2;

//renamed due to confusion with java.lang.Object
public class GameObject {
    Vector2 position;
    float globalRotation;

    public GameObject(double x, double y) {
        this.position = new Vector2(x, y);
    }

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
