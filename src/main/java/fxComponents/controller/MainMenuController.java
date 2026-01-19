package fxComponents.controller;

import fxComponents.AssetManager;
import fxComponents.RootManager;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    VBox root;

    @FXML
    public void initialize(){
        //setting the background
        ImageView bg = new ImageView(AssetManager.MAIN_BACKGROUND);
        root.getChildren().add(0, bg);
    }

    @FXML
    public void onSingleplayerButtonClick() {
        RootManager.switchTo("Singleplayer.fxml");
    }

    public void onMultiplayerButtonClick() {
        welcomeText.setText("Multiplayer ausgewählt");
    }
}
