package fxComponents.controller;

import fxComponents.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class SingleplayerMenuController {
    @FXML
    private ComboBox<String> trackBox;

    @FXML
    private void initialize(){
        trackBox.getItems().addAll(
                "Monza",
                "Spa",
                "Nürburgring"
        );
    }

    public void spielStarten() {
        SceneManager.switchTo("Game.fxml");
    }
}
