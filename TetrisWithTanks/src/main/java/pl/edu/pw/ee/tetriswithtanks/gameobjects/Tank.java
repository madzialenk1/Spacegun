package pl.edu.pw.ee.tetriswithtanks.gameobjects;

import java.util.Arrays;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class Tank extends GraphicObject {

    private final Rectangle tank;
    private final Rectangle gun;

    private final double maxGunAngle = 45;
    private double gunAngle = 0;

    private final int angleToRotate = 1;

    public Tank(double x, double tankWidth, double tankHeight, double gunWidth, PointsWithColor color, Pane gamePane) {
        super(gamePane, color);

        double tankY = gamePane.getMaxHeight() - tankHeight;
        tank = new Rectangle(x, tankY, tankWidth, tankHeight);
        tank.setFill(color.color);

        double gunX = x + tankWidth / 2 - gunWidth / 2;
        double gunY = tankY - tankHeight / 4;
        double gunHeight = tankHeight * 3 / 4;
        gun = new Rectangle(gunX, gunY, gunWidth, gunHeight);
        gun.setFill(color.color.darker());

        addTankToGamePane();
    }

    @Override
    public List<Shape> getShapes() {
        return Arrays.asList(new Shape[]{tank, gun});
    }

    public Bullet fire() {
        rotateGun(-gunAngle);

        double gunRadians = Math.toRadians(90 - gunAngle);
        double bulletX = gun.getX() + gun.getWidth() / 2 + gun.getHeight() * Math.cos(gunRadians);
        double bulletY = gun.getY() + gun.getHeight() - gun.getHeight() * Math.sin(gunRadians);

        rotateGun(gunAngle);

        double radius = gun.getWidth() / 2;

        Bullet bullet = new Bullet(bulletX, bulletY, gunAngle, radius, gamePane);

        return bullet;
    }

    public void gunRotateLeft() {
        if (gunAngle > -maxGunAngle) {
            gunAngle--;
            rotateGun(-angleToRotate);
        }
    }

    public void gunRotateRight() {
        if (gunAngle < maxGunAngle) {
            gunAngle++;
            rotateGun(angleToRotate);
        }
    }

    public void moveLeft(int step) {
        if (getX() - step > 0) {
            tank.setX(tank.getX() - step);

            rotateGun(-gunAngle);
            gun.setX(gun.getX() - step);
            rotateGun(gunAngle);
        }
    }

    public void moveRight(int step) {
        if (getX() + getWidth() + step < gamePane.getMaxWidth()) {
            tank.setX(tank.getX() + step);

            rotateGun(-gunAngle);
            gun.setX(gun.getX() + step);
            rotateGun(gunAngle);
        }
    }

    public double getX() {
        return tank.getX();
    }

    public double getWidth() {
        return tank.getWidth();
    }

    private void rotateGun(double angle) {
        double gunCenterX = gun.getX() + gun.getWidth() / 2;
        double gunDownY = gun.getY() + gun.getHeight();

        Rotate rotate = new Rotate();
        rotate.setAngle(angle);
        rotate.setPivotX(gunCenterX);
        rotate.setPivotY(gunDownY);

        gun.getTransforms().add(rotate);
    }

    private void addTankToGamePane() {
        gamePane.getChildren().addAll(getShapes());
    }

}
