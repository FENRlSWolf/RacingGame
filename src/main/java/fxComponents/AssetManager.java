package fxComponents;

import javafx.scene.image.Image;

public final class AssetManager {
    private AssetManager() {}

    //tracks
    public static final Image TRACK_CARPET = loadImage("/assets/tracks/Spieleteppich.png");

    //cars
    public static final Image CAR_RED = loadImage("/assets/cars/Car_red.png");

    private static Image loadImage(String path){
        return  new Image(AssetManager.class.getResourceAsStream(path));
    }
}
