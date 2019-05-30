package pl.edu.pw.ee.tetriswithtanks;

import java.util.ArrayList;
import java.util.List;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;
import javafx.application.Platform;

import pl.edu.pw.ee.tetriswithtanks.gameobjects.Bullet;

public class AutomaticMovesThread extends Thread {

    private static final Logger LOG = Logger.getLogger(AutomaticMovesThread.class.getName());

    private final List<Bullet> bullets;

    private final long bulletTimeToSlipInMillis = 10;
    private final long blockTimeToSlipInMillis = 10;

    public AutomaticMovesThread(List<Bullet> bullets) {
        this.bullets = bullets;

    }

    @Override
    public void run() {
        while (true) {
            moveBullets();

        }
    }

    private void moveBullets() {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        Bullet bullet;

        for (int i = 0; i < bullets.size(); i++) {
            bullet = bullets.get(i);
            if (bullet.isVisibleForPlayer()) {
                moveBullet(bullet);
            } else {
                markBulletAsDeleted(bullet, bulletsToRemove);
            }
        }

        bullets.removeAll(bulletsToRemove);

        try {
            Thread.sleep(bulletTimeToSlipInMillis);
        } catch (InterruptedException e) {
            LOG.log(INFO, "Something goes wrong during AutomaticMovesThread -> run() -> moveBullets() errorMessage: {0}", e.getMessage());
        }
    }

    private void moveBullet(Bullet bullet) {
        Platform.runLater(() -> {
            bullet.moveByStep();
        });
    }

    private void markBulletAsDeleted(Bullet bullet, List<Bullet> bulletsToRemove) {
        Platform.runLater(() -> {
            bullet.setVisible(false);
        });

        bulletsToRemove.add(bullet);
    }

}
