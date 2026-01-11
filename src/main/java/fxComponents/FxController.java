package fxComponents;

import javafx.fxml.FXML;

import javafx.scene.control.Label;


public class FxController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onSingleplayerButtonClick() {
        welcomeText.setText("Singleplayer ausgewählt");
    }

    public void onMultiplayerButtonClick() {
        welcomeText.setText("Multiplayer ausgewählt");
    }
}
