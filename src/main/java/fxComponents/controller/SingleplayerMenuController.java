package fxComponents.controller;

import fxComponents.AssetManager;
import fxComponents.RootManager;
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
                "Nürburgring",
                "Red Bull Ring"
        );

        trackBox.setOnAction(e -> {
            AssetManager.setSelectedTrack(trackBox.getValue());
        });
    }

    public void spielStarten() {
        RootManager.switchTo("Game.fxml");
    }
}
