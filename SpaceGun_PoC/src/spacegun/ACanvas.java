
package spacegun;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public abstract class ACanvas extends Canvas{
    BufferedImage image;
    Graphics2D graphics;
    
    ACanvas(int height,int width){
        super();
        setSize(height,width);
        image= new BufferedImage(height,width,BufferedImage.TYPE_INT_RGB);
        graphics=(Graphics2D) image.getGraphics();
    }
    public abstract void drawImage();
    private void onScreen(){
        Graphics g=getGraphics();
        g.drawImage(image, 10, 44, null);// wyglad okienka do gry
        g.dispose();
    }
    public void run(){
        drawImage();
        onScreen();
       
    }

    
}
