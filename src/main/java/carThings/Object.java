package carThings;

import Helpers.Vector2;

public class Object {
    public Object(double x, double y) {
        this.position.x = x;
        this.position.y = y;
    }

    Vector2 position;
    float rotation;

    void move(Vector2 vector2) {
        position.add(vector2);
    }

    void update(){

    }

    void rotate(float degrees) {
        rotation += degrees;
        if (rotation >= 360) {
            rotation -= 360;
        }
        else if (rotation < 0) {
            rotation += 360;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
