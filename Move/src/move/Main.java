
import javax.swing.JFrame;

public class Main {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        Move s = new Move();
       // Move2 x = new Move2();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);

    }
}
