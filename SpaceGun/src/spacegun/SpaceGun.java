package spacegun;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class SpaceGun extends JPanel implements Runnable{
static SpaceGun spacegun = new SpaceGun();
static Board board=new Board();
static Thread thread=new Thread(spacegun);

   

boolean start=false;
    public SpaceGun() {
        super();
        setBackground(Color.PINK);
        setLayout(null);
        start=true;

       }
 
        public static void main(String[] args) {
        
        JFrame jframe = new JFrame("SpaceGun");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(spacegun);
        jframe.setSize(600, 600);
        jframe.setLocationRelativeTo(null);
        board.setLocation(10, 10);
        spacegun.add(board);
        jframe.setResizable(false);
        jframe.setVisible(true);
        thread.start();
        
    }
// zrozumiec to co mowi Jstar o nanotime, przypisac poszczegolne przyciski dla kazdego uzytkownika, wątek dla animacji uzytkownikow 
    @Override
    public void run() {
    
        while(start){
         
            board.run();
          // tu musi byc watek odnosnie tego wrzucacza
            try {Thread.sleep(20);} 
            catch (InterruptedException e)
            {e.printStackTrace();}
            
            
        }
        
    }

}