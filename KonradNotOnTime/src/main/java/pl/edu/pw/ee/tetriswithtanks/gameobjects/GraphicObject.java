package pl.edu.pw.ee.tetriswithtanks.gameobjects;

import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class GraphicObject {

    final PointsWithColor pointsWithColor;
    final Pane gamePane;

    public GraphicObject(Pane gamePane, PointsWithColor color) {
        this.gamePane = gamePane;
        this.pointsWithColor = color;
    }

    public abstract List<Shape> getShapes();

    final void addShapeToGamePane(Shape shape) {
        gamePane.getChildren().add(shape);
    }

    final void removeShapeFromGamePane(Shape shape) {
        gamePane.getChildren().remove(shape);
    }

}
