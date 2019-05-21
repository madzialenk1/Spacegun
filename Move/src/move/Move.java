
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics.*;

public class Move extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 300, velx = 0, vely = 0;

     private final double maxGunAngle = 45;
    private double gunAngle = 0;

    public Move() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D body = (Graphics2D) g;
        Graphics2D gun = (Graphics2D) g;
        body.fill(new Rectangle2D.Double(x, y, 40, 40));
        gun.fill(new Rectangle2D.Double(x+10, y-20, 20, 60));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x += velx;
        y += vely;
    }

    /*public void up() {
        vely = -1.5;
        velx = 0;
    }
    
    public void down() {
        vely = 1.5;
        velx = 0;
    }*/
    
      public void left() {
        velx = -1.5;
        vely = 0;
    }
      
        public void right() {
        velx = 1.5;
        vely = 0;
    }
        
        public void stop(){
           velx= 0;
           vely= 0;
             
        }
        
    @Override
     public void keyPressed(KeyEvent e){
         int code = e.getKeyCode();
         /*if(code == KeyEvent.VK_UP){
             up();
         }
         if(code == KeyEvent.VK_DOWN){
             down();
         }*/
         if(code == KeyEvent.VK_LEFT){
             left();
         }
         if(code == KeyEvent.VK_RIGHT){
             right();
         }
     }
    @Override
     public void keyTyped(KeyEvent e) {}
    @Override
     public void keyReleased(KeyEvent e) {
     int code = e.getKeyCode();
         /*if(code == KeyEvent.VK_UP){
             stop();
         }
         if(code == KeyEvent.VK_DOWN){
             stop();
         }*/
         if(code == KeyEvent.VK_LEFT){
             stop();
         }
         if(code == KeyEvent.VK_RIGHT){
             stop();
         }
     }

     
     
     
     //////////////////////////////////////////////

     
     
}

