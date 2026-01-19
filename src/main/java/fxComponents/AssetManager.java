package fxComponents;

import javafx.scene.image.Image;

// final because nothing should be changed while running
public final class AssetManager {
    private AssetManager() {}

    //tracks
    public static final Image TRACK_CARPET = loadImage("/assets/tracks/Spieleteppich.png");

    //cars
    public static final Image CAR_RED = loadImage("/assets/cars/Car_red.png");

    //backgrounds
    public static final Image MAIN_BACKGROUND = loadImage("/assets/backgrounds/testBG.gif");

    private static Image loadImage(String path){
        return  new Image(AssetManager.class.getResourceAsStream(path));
    }
}
