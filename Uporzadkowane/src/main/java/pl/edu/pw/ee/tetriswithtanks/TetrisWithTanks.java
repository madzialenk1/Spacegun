package pl.edu.pw.ee.tetriswithtanks;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import pl.edu.pw.ee.tetriswithtanks.gameobjects.Bullet;
import static pl.edu.pw.ee.tetriswithtanks.gameobjects.PointsWithColor.PLAYER_1;
import static pl.edu.pw.ee.tetriswithtanks.gameobjects.PointsWithColor.PLAYER_2;
import pl.edu.pw.ee.tetriswithtanks.gameobjects.Tank;

public class TetrisWithTanks extends Application {

    private final int sceneWidth = 800;
    private final int sceneHeight = 600;
    private final int scoresPanelHeight = 100;
    private final int gamePanelHeight = sceneHeight - scoresPanelHeight;
    private final int tankWidth = 50;
    private final int tankHeight = 70;
    private final int gunWidth = 20;
    private final int blockWidth = 70;
    private final int blockHeight = 70;
    List drop = new ArrayList();
    Pane root = new Pane();
    AnimationTimer timer;
    double speed;
    private Tank leftPlayer;
    private Tank rightPlayer;

    Rectangle cont;
    double falling;
    boolean dead = false;

    private final List<Bullet> bullets;

    public TetrisWithTanks() {
        bullets = new ArrayList<>();

    }
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button1 = new Button("Start game");
        button1.setPrefHeight(50);
        button1.setPrefWidth(150);
        button1.setTranslateY(-100);
        button1.setOnAction(e -> startGame(primaryStage));

        Button button2 = new Button("Designers");
        button2.setPrefHeight(50);
        button2.setPrefWidth(150);
        button2.setTranslateY(0);
        button2.setOnAction(e -> primaryStage.setScene(scene2));

        Button button3 = new Button("Exit");
        button3.setPrefHeight(50);
        button3.setPrefWidth(150);
        button3.setTranslateY(100);
        button3.setOnAction(e -> System.exit(0));

        Button button4 = new Button("Back");
        button4.setPrefHeight(50);
        button4.setPrefWidth(150);
        button4.setTranslateY(100);
        button4.setOnAction(e -> primaryStage.setScene(scene1));

        Label label1 = new Label("Ruciński Konrad");
        label1.setTranslateY(-100);
        label1.setFont(new Font("Arial", 30));

        Label label2 = new Label("Magdalena Pękacka");
        label2.setTranslateY(0);
        label2.setFont(new Font("Arial", 30));

        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(button1, button2, button3);
        scene1 = new Scene(layout1, 800, 600);
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label1, label2, button4);
        scene2 = new Scene(layout2, 800, 600);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Main menu");
        primaryStage.show();

    }

    void kys() {
        System.out.println("KYS");

    }

    public void startGame(Stage primaryStage) {
        speed = 1;
        Group root = new Group();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        GridPane mainGrid = prepareGridPane();
        GridPane scoresGrid = new GridPane();
        mainGrid.add(scoresGrid, 0, 0);

        prepareLeftScoresPane(scoresGrid);
        prepareRightScoresPane(scoresGrid);
        Pane gamePane = prepareGamePane(mainGrid);

        preparePlayers(gamePane);

        falling = 500;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {

            speed += falling / 8000;
            drop.add(rectangle());
            root.getChildren().add(((Node) drop.get(drop.size() - 1)));
        }));

        timeline.setCycleCount(1000);
        timeline.play();

        timer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                gameUpdate();

            }

        };
        timer.start();

        scene.setOnKeyPressed(tankController());

        root.getChildren().add(mainGrid);

        primaryStage.setTitle("SpaceGun");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        startAutomaticMoves(bullets);

    }

    public static void main(String[] args) {
        launch(args);
    }

    private GridPane prepareGridPane() {
        GridPane grid = new GridPane();
        grid.setMaxSize(sceneWidth, sceneHeight);
        return grid;
    }

    private void prepareLeftScoresPane(GridPane grid) {
        Pane leftScoresPane = prepareScoresPane();
        grid.add(leftScoresPane, 0, 0);
    }

    private void prepareRightScoresPane(GridPane grid) {
        Pane rightScoresPane = prepareScoresPane();
        grid.add(rightScoresPane, 1, 0);
    }

    private Pane prepareScoresPane() {
        StackPane scoresPane = new StackPane();
        scoresPane.setAlignment(Pos.CENTER);
        scoresPane.setMinSize(sceneWidth / 2, scoresPanelHeight);
        scoresPane.setMaxSize(sceneWidth / 2, scoresPanelHeight);

        Text points = new Text("Tu mają być punkty gracza");
        scoresPane.getChildren().add(points);

        return scoresPane;
    }

    private Pane prepareGamePane(GridPane grid) {
        Pane gamePane = new Pane();
        gamePane.setMinSize(sceneWidth, gamePanelHeight);
        gamePane.setMaxSize(sceneWidth, gamePanelHeight);
        gamePane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        //Aliceblue

        grid.add(gamePane, 0, 1);

        return gamePane;
    }

    private void preparePlayers(Pane gamePane) {
        leftPlayer = new Tank(0, tankWidth, tankHeight, gunWidth, PLAYER_1, gamePane);

        double player2StartX = sceneWidth - tankWidth;
        rightPlayer = new Tank(player2StartX, tankWidth, tankHeight, gunWidth, PLAYER_2, gamePane);
    }

    private TankKeyEventController tankController() {
        return new TankKeyEventController(leftPlayer, rightPlayer, bullets);
    }

    private void startAutomaticMoves(List<Bullet> bullets) {
        AutomaticMovesThread automaticMoves = new AutomaticMovesThread(bullets);

        automaticMoves.start();

    }

    public void gameUpdate() {

        for (int i = 0; i < drop.size(); i++) {
            ((Rectangle) drop.get(i)).setLayoutY(((Rectangle) drop.get(i)).getLayoutY() + speed);

            //if missed remove
            if (((Rectangle) drop.get(i)).getLayoutY() >= 700) {
                root.getChildren().remove(((Rectangle) drop.get(i)));
                drop.remove(i);

            }
        }

    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    Color kolor = Color.GREEN;

    public Rectangle rectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(rand(70, 700));
        rectangle.setLayoutY(1);
        rectangle.setHeight(50);
        rectangle.setWidth(70);

        rectangle.setFill(kolor);
        return rectangle;

    }

    void changeColor() {
        kolor = Color.ALICEBLUE;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

}
