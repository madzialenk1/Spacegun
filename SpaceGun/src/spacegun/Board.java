package spacegun;

import java.awt.Color;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
// to jest do obslugi myszki i klawiatury bedzie to potrzebne do czolgow




public class Board extends ACanvas {
    final static int HEIGHT=Blocks.SIZE*10;
    final static int WIDTH=Blocks.SIZE*20;
    int blockX,blockY; // obecne polozenie klocka we wspolrzednych x i y
    double speed,speedMax; // predkosc
    Block block=new Block();
    int tab[][]= new int[20][21];
   
    boolean gamePlay;
    
    
    public Board() {
        super(HEIGHT, WIDTH);
      // addMouseListener(this);
      // addKeyListener(this); // czolgi 
      
       speedMax = 9;
       gamePlay=true;
      // this.blockX=1;
       //this.blockY=8;
      
        
    }
    public double getX(double x){
        return x;
    }
    public void setX(int x){
        this.blockX=x;
        
    }
    private void printBlock(int x, int y, int k)
	{
            graphics.setColor(Blocks.KOLOR[k]);
            graphics.fillRect((x*Blocks.SIZE)-Blocks.SIZE, (y*Blocks.SIZE)-Blocks.SIZE, Blocks.SIZE, Blocks.SIZE);
            graphics.setColor(Color.BLACK);
            graphics.drawRect((x*Blocks.SIZE)-Blocks.SIZE, (y*Blocks.SIZE)-Blocks.SIZE, Blocks.SIZE-1, Blocks.SIZE-1);
	} // stworzenie wygladu klocków
    
   private void printBlock(int x, int y){
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               if(block.tab[i][j]) // drukuje ksztalt klocka
                   printBlock(i+x,j+y,block.aBlock+2);// ten 3 argument to kolor jaki maja klocki
           }
       }
   }
   
    @Override
    public void drawImage() {
     if(gamePlay){
       printBoard();
       printBlock(blockX,blockY);
       if (speed<speedMax)speed++;
           else {
                    speed=0.0001;
      if (isBlockOnTheBoard()){ 
          blockY++;
       }
         }
    
     }}
    
   private boolean isBlockOnTheBoard()
	{
            return true; // caly czas jest true czyli klocek poprostu wyjedzie za plansze bo sie nie zmienia na false 
	}
   
    
    private void printBoard()
	{
            for (int x=1; x<19; x++)
            for (int y=1; y<21; y++)
		{
		graphics.setColor(Blocks.KOLOR[tab[x][y]]);
		graphics.fillRect((x*Blocks.SIZE)-Blocks.SIZE, (y*Blocks.SIZE)-Blocks.SIZE, Blocks.SIZE, Blocks.SIZE);
		graphics.setColor(Color.BLACK);
		if (tab[x][y] > 0)
                    graphics.drawRect((x * Blocks.SIZE) - Blocks.SIZE, (y * Blocks.SIZE) - Blocks.SIZE, Blocks.SIZE - 1, Blocks.SIZE-1);
			}
	}

   /*
   czolgi to mozna zmienic tak jak jstar mowil na mouselistener, zeby nie bylo 
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

   }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }*/
    
    
}
