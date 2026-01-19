package fxComponents;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RootManager {
    private static Stage stage;
    private static Scene scene;

    //once in Main-class
    public static void init(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(RootManager.class.getResource("/ui/MainMenu.fxml"));
        scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void switchTo(String fxmlFile) {
        try {
            Parent newRoot = FXMLLoader.load(RootManager.class.getResource("/ui/" + fxmlFile));
            scene.setRoot(newRoot);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double windowWidth() {
        return stage.getScene().getWidth();
    }

    public static double windowHeight() {
        return stage.getScene().getHeight();
    }
}
