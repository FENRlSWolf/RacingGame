package fxComponents.Controller;

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
}
