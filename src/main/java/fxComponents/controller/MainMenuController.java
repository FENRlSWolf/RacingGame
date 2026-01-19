package fxComponents.controller;

import fxComponents.RootManager;
import javafx.fxml.FXML;

import javafx.scene.control.Label;


public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onSingleplayerButtonClick() {
        RootManager.switchTo("Singleplayer.fxml");
    }

    public void onMultiplayerButtonClick() {
        welcomeText.setText("Multiplayer ausgewählt");
    }
}
