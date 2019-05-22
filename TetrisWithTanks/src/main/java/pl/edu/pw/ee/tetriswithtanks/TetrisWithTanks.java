package pl.edu.pw.ee.tetriswithtanks;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.edu.pw.ee.tetriswithtanks.gameobjects.Block;
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

    private Tank leftPlayer;
    private Tank rightPlayer;
    private Block block;

    private final List<Bullet> bullets;
    private final List<Block> blocks;

    public TetrisWithTanks() {
        bullets = new ArrayList<>();
        blocks = new ArrayList<>();
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        GridPane mainGrid = prepareGridPane();
        GridPane scoresGrid = new GridPane();
        mainGrid.add(scoresGrid, 0, 0);

        prepareLeftScoresPane(scoresGrid);
        prepareRightScoresPane(scoresGrid);
        Pane gamePane = prepareGamePane(mainGrid);

        preparePlayers(gamePane);
        prepareBlocks( gamePane);

        scene.setOnKeyPressed(tankController());

        root.getChildren().add(mainGrid);

        primaryStage.setTitle("JiMP2 -- Battlefield 2019");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        startAutomaticMoves(bullets,blocks);
        
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

        grid.add(gamePane, 0, 1);

        return gamePane;
    }

    private void preparePlayers(Pane gamePane) {
        leftPlayer = new Tank(0, tankWidth, tankHeight, gunWidth, PLAYER_1, gamePane);

        double player2StartX = sceneWidth - tankWidth;
        rightPlayer = new Tank(player2StartX, tankWidth, tankHeight, gunWidth, PLAYER_2, gamePane);
    }
    private void prepareBlocks(Pane gamePane) {
        block = new Block(100, blockWidth, blockHeight, gamePane,PLAYER_1);

        
    }
    
    

    private TankKeyEventController tankController() {
        return new TankKeyEventController(leftPlayer, rightPlayer, bullets);
    }

    private void startAutomaticMoves(List<Bullet> bullets,List<Block> blocks) {
        AutomaticMovesThread automaticMoves = new AutomaticMovesThread(bullets,blocks);
        
        automaticMoves.start();
        
    }
    

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

}
