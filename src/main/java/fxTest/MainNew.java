package fxTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//to start use maven -> Plugins -> Javafx -> javafx:run
public class MainNew extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainNew.class.getResource("/ui/test.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Testseite");
        stage.setScene(scene);
        stage.show();
    }

    static void main() {
        launch();
    }
}
