import Helpers.Vector2;

public class Object {
    Vector2 position;
    float globalRotation;

    void move(Vector2 vector2) {
        position.add(vector2);
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
}
