package pl.edu.pw.ee.tetriswithtanks;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneLib {

    private static Stage primary;
    private static Scene sceneOne = new Scene(new SceneOne(),800, 600);
    //private static Scene sceneTwo = new Scene(new SceneTwo(), 500, 500);
    //private static Scene sceneThree = new Scene(new SceneThree(), 500, 500);
  //  private static Scene sceneFour = new Scene(new SceneFour(), 750, 600);

    public static void setPrimary(Stage primary) {
        SceneLib.primary = primary;
    }

    public static void switchtoOne() {
        sceneOne = new Scene(new SceneOne(), 800, 600);
        primary.centerOnScreen();
        primary.setScene(sceneOne);
    }
/*
    public static void switchtoTwo() {

        primary.setScene(sceneTwo);
        primary.centerOnScreen();
    }

    public static void switchtoThree() {

        primary.setScene(sceneThree);
        primary.centerOnScreen();

    }

    public static void switchtoFour() {

        primary.setScene(sceneFour);
        primary.centerOnScreen();
    }*/

    public static void end() {
        primary.close();
    }
/*
    public static void setNumberOfPairs(int x) { // ???????????
        SceneOne.numberOfPairs = x;

    }

    public static void easy() {
        SceneLib.setNumberOfPairs(4);
        SceneLib.switchtoOne();
        primary.centerOnScreen();
    }

    public static void medium() {

        SceneLib.setNumberOfPairs(8);
        SceneLib.switchtoOne();
        primary.centerOnScreen();
    }

    public static void hard() {
        SceneLib.setNumberOfPairs(12);
        SceneLib.switchtoOne();
        primary.centerOnScreen();
    }**/

}
