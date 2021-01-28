package Game;

import java.awt.*;
import javax.swing.*;

public class GameTile extends JFrame {

    private int row;
    private int col;
    public static final int TILE_SIZE = 100;
    public static final int extraSpace = 20;

    public GameTile(int row,int col){
        this.row = row;
        this.col = col;


    }

    public void render(Graphics g){
        paintGameTiles(g);
        boardGridPainter(g);
   }


    /**
     * This method paints our grid for the board
     * @param g
     */
    private void boardGridPainter(Graphics g){
        g.setColor(Color.black);
        for(int i = 0; i <=400; i+= 100){
            for (int j = 20; j<= 420; j += 100){
                g.drawRect(i,j,100,100);
            }
        }
    }

    /**
     *
     * @param g
     * @param row
     * @param col
     * Method for checking the received color and change it for the desired one.
     */
    public void colorSwitcher(Graphics g,int row,int col){
        if (isTileOrange(row, col)) {
            g.setColor(new Color(252, 90, 3));

        }
        else if (isTileDarkGray(row, col)) {
            g.setColor(Color.DARK_GRAY);
        }
        else if (isTileGray(row,col)){
            g.setColor(Color.GRAY);
        }
        else g.setColor(Color.WHITE);


    }
    private boolean isTileOrange(int row,int col){
         return ((row == 0 && col == 0) ||
                (row == 0 && col == 4) ||
                (row == 4 && col == 1) ||
                (row == 4 && col == 3));

    }
    private boolean isTileDarkGray(int row,int col){
        return ((row == 0 && col == 1) ||
                (row == 0 && col == 3) ||
                (row == 4 && col == 0) ||
                (row == 4 && col == 4));

    }
    private boolean isTileGray (int row,int col) {
        return ((row == 1 && col == 0) ||
                (row == 1 && col == 1) ||
                (row == 1 && col == 3) ||
                (row == 1 && col == 4) ||
                (row == 3 && col == 0) ||
                (row == 3 && col == 1) ||
                (row == 3 && col == 3) ||
                (row == 3 && col == 4));

    }
    public void paintGameTiles(Graphics g){
        for (int x = 0; x<5;x++){
            for (int y = 0; y<5;y++){
                colorSwitcher(g,y,x);
                g.fillRect(x*TILE_SIZE,y*TILE_SIZE+extraSpace,TILE_SIZE,TILE_SIZE);
            }
        }
    }







}
