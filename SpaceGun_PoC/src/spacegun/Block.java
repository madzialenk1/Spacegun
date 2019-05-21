package spacegun;


public class Block {
    boolean [][] tab=new boolean[4][4];//tablica tych klockow z Blocks są one jako true i false
    int aBlock;// do wybrania ktory chce klocek 
    Block(){
        setBlock((int)0);// rodzaj klocka
        
    }
    public void setBlock(int b){
        aBlock=b; // wybranie ktory chce klocek z tamtej tablicy z Blocks
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                tab[i][j]=Blocks.BLOCKS[aBlock][i][j];
                
            }
        }
    }
    
}
