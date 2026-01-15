package fxComponents.Controller;

import carThings.Car;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

// for Game Loop code
public class GameController {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private AnimationTimer gameLoop;

    private final Set<KeyCode> keyPressed = new HashSet<>();

    private Car playerCar;

    private long lastTime = 0;

    //JavaFX lifecycle
    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        playerCar = new Car(0, 0);

        Platform.runLater(this::setupInput);
        drawTrack(); //just for testing :)
    }

    // Input
    private void setupInput() {
        Scene scene = canvas.getScene();
        scene.setOnKeyPressed(event -> keyPressed.add(event.getCode()));
        scene.setOnKeyReleased(event -> keyPressed.remove(event.getCode()));
    }

    //Game Loop start
    private void startGameLoop() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }
                double deltaTime = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                update(deltaTime);
                render();
            }
        };
        gameLoop.start();
    }

    //Update all things that move
    private void update(double dt) {
        playerCar.update();
    }

    //Render all things you can see
    private void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.save();

        //camera follows car
        gc.translate(canvas.getWidth() / 2 - playerCar.getPosition().x,
                canvas.getHeight() / 2 - playerCar.getPosition().y);

        drawTrack();
        playerCar.draw(gc);

        gc.restore();
    }

    private void drawTrack(){
        //Spielteppich Straße zum Test?
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\RacingGame\\src\\main\\resources\\tracks\\Spieleteppich.png")){
            Image image = new Image(fis);
            gc.drawImage(image, 0, 0, 1280, 720);
        } catch (IOException e){
            System.err.println("PNG file not found: " + e.getMessage());
        }
    }

    //must be called when scene switch happens
    public void stopGame(){
        if (gameLoop != null){
            gameLoop.stop();
        }
    }
}
