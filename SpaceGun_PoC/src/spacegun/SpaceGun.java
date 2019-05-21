package spacegun;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceGun extends JPanel implements Runnable {

    static SpaceGun spacegun = new SpaceGun();
    static Board board = new Board();
    static Thread thread = new Thread(spacegun);

    boolean start = false;

    public SpaceGun() {
        super();
        setBackground(Color.BLUE);
        setLayout(null);
        start = true;

    }

    public static void main(String[] args) {
        Tank s = new Tank();
        JFrame f = new JFrame("SpaceGun");

            //f.add(board, s);
         f.add(spacegun);
        spacegun.add(board, s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        s.setVisible(true);
        
        f.setLocationRelativeTo(null);
        board.setLocation(10, 10);

       
        f.setResizable(false);
       // spacegun.add(s);
       thread.start();

    }
// zrozumiec to co mowi J* o nanotime, przypisac poszczegolne przyciski dla kazdego uzytkownika, wątek dla animacji uzytkownikow 

    @Override
    public void run() {

        while (start) {

            board.run();
            // tu musi byc watek odnosnie tego wrzucacza
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
