package pl.edu.pw.ee.tetriswithtanks.gameobjects;

import java.util.Arrays;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import static pl.edu.pw.ee.tetriswithtanks.gameobjects.PointsWithColor.BULLET_BLUE;

public class Bullet extends GraphicObject {

    private final double moveStep = 5;

    private final double angle;
    private final double radius;
    private final Circle circle;

    public Bullet(double centerX, double centerY, double angle, double radius, Pane pane) {
        super(pane, BULLET_BLUE);
        this.angle = angle;
        this.radius = radius;

        circle = new Circle(centerX, centerY, radius, pointsWithColor.color);

        addShapeToGamePane(circle);
    }

    @Override
    public List<Shape> getShapes() {
        return Arrays.asList(new Shape[]{circle});
    }

    public void moveByStep() {
        double radians = Math.toRadians(angle);

        circle.setCenterX(circle.getCenterX() + moveStep * Math.sin(radians));
        circle.setCenterY(circle.getCenterY() - moveStep * Math.cos(radians));
    }

    public void setVisible(boolean visible) {
        circle.setVisible(visible);
    }

    public boolean isVisibleForPlayer() {
        if (circle.getCenterY() + radius > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        removeShapeFromGamePane(circle);
        super.finalize();
    }

}
