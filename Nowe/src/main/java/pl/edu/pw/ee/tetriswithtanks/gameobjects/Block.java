/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pw.ee.tetriswithtanks.gameobjects;

import java.util.Arrays;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author madzia
 */
public class Block extends GraphicObject {
    private final Rectangle block;
    
    
    public Block(double x, double blockWidth, double blockHeight,Pane gamePane, PointsWithColor color) {
        super(gamePane, color);
        double tankY = gamePane.getMaxHeight() - blockHeight-400;
        block = new Rectangle(x, tankY, blockWidth, blockHeight);
        block.setFill(color.color);
        addBlockToGamePane();
        System.out.println("Kasia");
    }
public void moveByStep() {
      block.setX(block.getX());// i tu, wydaje mi sie ze z wymiarami jest cos nie halo, nie zbiera dobrze miejsca w ktorym jest klocek
      block.setY(block.getY());// tu jest cos zle
    }
public void setVisible(boolean visible) {
        block.setVisible(visible);
    }

   
    @Override
    public List<Shape> getShapes() {
        return Arrays.asList(new Shape[]{block});
        
    }
    private void addBlockToGamePane() {
        gamePane.getChildren().addAll(getShapes());
    }
    @Override
    protected void finalize() throws Throwable {
        removeShapeFromGamePane(block);
        super.finalize();
    }

    
}
