package fxComponents;

import javafx.application.Application;
import javafx.stage.Stage;

//to start use maven -> Plugins -> Javafx -> javafx:run
public class MainNew extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        RootManager.init(stage);

        RootManager.switchTo("MainMenu.fxml");
        stage.setTitle("Racing Game Hauptmenü");
    }

    static void main() {
        launch();
    }
}
