package pl.edu.pw.ee.tetriswithtanks;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import pl.edu.pw.ee.tetriswithtanks.gameobjects.Bullet;
import pl.edu.pw.ee.tetriswithtanks.gameobjects.Tank;
import static pl.edu.pw.ee.tetriswithtanks.gameobjects.Tank.rightmoveleft;
import static pl.edu.pw.ee.tetriswithtanks.gameobjects.Tank.rightmoveright;

public class TankKeyEventController implements EventHandler<KeyEvent> {

    private static final Logger LOG = Logger.getLogger(TankKeyEventController.class.getName());

    private final Tank leftPlayer;
    private final Tank rightPlayer;
    private final List<Bullet> bulletsInGame;

    private final int moveStep = 5;

    public TankKeyEventController(Tank leftPlayer, Tank rightPlayer, List<Bullet> bulletsInGame) {
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.bulletsInGame = bulletsInGame;
    }

    public static void stop() {
        try {
            Thread.sleep(400);
        } catch (Exception e) {
        }
    }
    public int fire1 = 0;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:

                fire(rightPlayer);

                //stop();
                break;

            case LEFT:

                if ((leftPlayer.getX() + leftPlayer.getWidth() < rightPlayer.getX())) {
                    rightPlayer.moveLeft(moveStep);

                }
                break;

            case RIGHT:
                rightPlayer.moveRight(moveStep);

                break;

            case HOME:
                rightPlayer.gunRotateLeft();
                break;

            case PAGE_UP:
                rightPlayer.gunRotateRight();
                break;

            case W:
                fire(leftPlayer);
                break;

            case A:

                leftPlayer.moveLeft(moveStep);
                break;

            case D:
                if (leftPlayer.getX() + leftPlayer.getWidth() < rightPlayer.getX()) {
                    leftPlayer.moveRight(moveStep);
                }

                break;

            case Q:
                leftPlayer.gunRotateLeft();
                break;

            case E:
                leftPlayer.gunRotateRight();
                break;

            default:
                LOG.log(INFO, "Handle unsupported key: {0}", event.getCode());
        }
    }

    private void fire(Tank player) {

        Bullet bullet = player.fire();
        bulletsInGame.add(bullet);

    }

}
