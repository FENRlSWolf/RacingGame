import helpers.Vector2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Vector2 v2 = new Vector2(1,1);
    System.out.println(v2.magnitude());
    v2.normalize();
    System.out.println(v2.magnitude() + " " + v2.x + ", " + v2.y);
    v2.setToLength(30);
    System.out.println(v2.magnitude());
    v2.normalize();
    System.out.println(v2.magnitude());
}