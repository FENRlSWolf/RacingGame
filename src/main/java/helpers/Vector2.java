package helpers;

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

    public void rotate(double degrees) {
        double oldX = x;
        x = x * Math.cos(degrees) - y * Math.sin(degrees);
        y = oldX * Math.sin(degrees) + y * Math.cos(degrees);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    // added protection for dividing through 0
    public void normalize() {
            double mag = magnitude();
            if (mag < 1e-8) return;
            x /= mag;
            y /= mag;
    }

    public void setToLength(double length) {
        normalize();
        multiply(length);
    }


    public void multiply(double d) {
        x *= d;
        y *= d;
    }

    public Vector2 multiplyAndReturn(double d) {
        return new Vector2(x * d, y * d);
    }


    public void multiply(Vector2 vector2) {
        x *= vector2.x;
        y *= vector2.y;
    }

    public Vector2 multiplyAndReturn(Vector2 vector2) {
        return new Vector2(x * vector2.x, y * vector2.y);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}
