package pl.edu.pw.ee.tetriswithtanks;

import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class SceneOne extends StackPane {

    static int size;

    public SceneOne() {
        Label difficultyLabel = new Label("Poziom Trudności");
        difficultyLabel.setFont(Font.font(50));
        difficultyLabel.setTranslateY(-200);
        difficultyLabel.setFont(new Font("Jokerman", 30));

        Button easy = new Button("Łatwy");
        easy.setPrefHeight(50);
        easy.setPrefWidth(150);
        easy.setFont(new Font("Jokerman", 30));

        //easy.setOnAction(Event -> SceneLib.easy());

        easy.setTranslateY(-75);

        Button medium = new Button("Średni");
     //   medium.setOnAction(Event -> SceneLib.medium());
        medium.setTranslateY(0);
        medium.setPrefHeight(50);
        medium.setPrefWidth(150);
        medium.setFont(new Font("Jokerman", 30));

        Button hard = new Button("Trudny");
       // hard.setOnAction(Event -> SceneLib.hard());
        hard.setTranslateY(75);
        hard.setPrefHeight(50);
        hard.setPrefWidth(150);
        hard.setFont(new Font("Jokerman", 30));
        getChildren().addAll(easy, medium, hard, difficultyLabel);

    }
}
