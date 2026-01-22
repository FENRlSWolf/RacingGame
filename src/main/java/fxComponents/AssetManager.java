package fxComponents;

import javafx.scene.image.Image;

// final because nothing should be changed while running
public final class AssetManager {
    private AssetManager() {}

    static String selectedTrack = "Test";

    //tracks
    public static final Image TRACK_CARPET = loadImage("/assets/tracks/Spieleteppich.png");
    public static final Image REDBULL_RING = loadImage("/assets/tracks/RedBullRing.png");
    //cars
    public static final Image CAR_RED = loadImage("/assets/cars/Car_red.png");

    //backgrounds
    public static final Image MAIN_BACKGROUND = loadImage("/assets/backgrounds/testBG.gif");

    private static Image loadImage(String path){
        return  new Image(AssetManager.class.getResourceAsStream(path));
    }

    //extendable for later when coosing cars matter
    public static void setSelectedTrack(String path){
        selectedTrack = path;
    }

    public static Image getSelectedTrack(){
        if (selectedTrack.equals("Red Bull Ring")){
            return AssetManager.REDBULL_RING;
        } else {
            return AssetManager.TRACK_CARPET;
        }
    }


}
