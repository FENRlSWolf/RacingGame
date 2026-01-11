package fxTest;

import javafx.fxml.FXML;

import javafx.scene.control.Label;


public class FxController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {welcomeText.setText("Welcome to our first JavaFX Application :)");}
}
