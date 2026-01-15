//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    while (true) {
        PlayerInput playerInput = new PlayerInput();
        playerInput.calcInputVector();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}