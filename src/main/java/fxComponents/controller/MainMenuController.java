package fxComponents.controller;

import fxComponents.SceneManager;
import javafx.fxml.FXML;

import javafx.scene.control.Label;


public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onSingleplayerButtonClick() {
        SceneManager.switchTo("Singleplayer.fxml");
    }

    public void onMultiplayerButtonClick() {
        welcomeText.setText("Multiplayer ausgewählt");
    }
}
