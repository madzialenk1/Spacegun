
package spacegun;

import java.awt.Color;


public class Blocks {
    final static short SIZE = 25;
	final static Color[] KOLOR = {new Color(64,0,128), Color.RED, Color.GREEN, 
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.WHITE};
    final static boolean [] [] [] BLOCKS={
        {
            {false,false,false,false},
            {true,true,true,true},
            {false,true,true,false},
            {false,false,false,false},
        },
        {
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
        }
        };

}