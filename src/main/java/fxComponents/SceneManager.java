package fxComponents;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    //once in Main-class
    public static void init(Stage primaryStage){
        stage = primaryStage;
    }

    public static void switchTo(String fxmlFile){
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/ui/" + fxmlFile));
            Scene scene = new Scene(loader.load(), 320, 240);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException("Kann FXML nicht laden: " + fxmlFile, e);
        }
    }
}
