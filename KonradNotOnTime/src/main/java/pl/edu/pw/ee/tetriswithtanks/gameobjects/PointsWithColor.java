package pl.edu.pw.ee.tetriswithtanks.gameobjects;

import javafx.scene.paint.Color;

public enum PointsWithColor {
    BULLET_BLUE(0, Color.BLUEVIOLET),
    PLAYER_1(0, Color.BISQUE),
    PLAYER_2(0, Color.DARKORANGE);

    final int points;
    final Color color;

    private PointsWithColor(int points, Color color) {
        this.points = points;
        this.color = color;
    }

}
