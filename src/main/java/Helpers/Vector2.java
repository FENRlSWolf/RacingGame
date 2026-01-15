package Helpers;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
    }

    public void subtract(Vector2 vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
    }

    public void rotate(float degrees) {
        x = x * Math.cos(degrees) - y * Math.sin(degrees);
        y = x * Math.sin(degrees) + y * Math.cos(degrees);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public void normalize() {
        x /= magnitude();
        y /= magnitude();
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}
