
package spacegun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Tank extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 0, velx = 0, vely = 0;

    public Tank() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Rectangle2D.Double(x, y, 40, 40));

    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        x += velx;
        y += vely;
    }

    public void up() {
        vely = -1.5;
        velx = 0;
    }
    
    public void down() {
        vely = 1.5;
        velx = 0;
    }
    
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
        
     public void keyPressed(KeyEvent e){
         int code = e.getKeyCode();
         if(code == KeyEvent.VK_UP){
             up();
         }
         if(code == KeyEvent.VK_DOWN){
             down();
         }
         if(code == KeyEvent.VK_LEFT){
             left();
         }
         if(code == KeyEvent.VK_RIGHT){
             right();
         }
     }
     public void keyTyped(KeyEvent e) {}
     public void keyReleased(KeyEvent e) {
     int code = e.getKeyCode();
         if(code == KeyEvent.VK_UP){
             stop();
         }
         if(code == KeyEvent.VK_DOWN){
             stop();
         }
         if(code == KeyEvent.VK_LEFT){
             stop();
         }
         if(code == KeyEvent.VK_RIGHT){
             stop();
         }
     }
     
     
}

