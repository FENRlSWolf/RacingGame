import Helpers.Vector2;

public class Object {
    Vector2 position;
    float rotation;

    void move(Vector2 vector2) {
        position.add(vector2);
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
}
