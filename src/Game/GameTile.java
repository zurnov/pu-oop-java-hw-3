package Game;

import Piece.GuardPiece;
import Piece.LeaderPiece;

import java.awt.*;
import javax.swing.*;

public class GameTile extends JFrame {

    private int row;
    private int col;
    private int tileSize;

    public GameTile(int row,int col){
        this.row = row;
        this.col = col;
        this.tileSize = 100;

    }

    public void render(Graphics g){
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
        //Painting Orange Tiles
        if((this.row == 0 && this.col == 0) ||
                (this.row == 0 && this.col == 4) ||
                (this.row == 4 && this.col == 1) ||
                (this.row == 4 && this.col == 3)) {
            g.setColor(Color.orange);
            g.fillRect(tileX,tileY,this.tileSize, this.tileSize);
        }
        //Paining Gray tiles
        else if((this.row == 0 && this.col == 1) ||
                (this.row == 0 && this.col == 3) ||
                (this.row == 4 && this.col == 0) ||
                (this.row == 4 && this.col == 4)) {
            g.setColor(Color.darkGray);
            g.fillRect(tileX,tileY,this.tileSize, this.tileSize);
        }
        else if((this.row == 1 && this.col == 0) ||
                (this.row == 1 && this.col == 1) ||
                (this.row == 1 && this.col == 3) ||
                (this.row == 1 && this.col == 4) ||
                (this.row == 3 && this.col == 0) ||
                (this.row == 3 && this.col == 1) ||
                (this.row == 3 && this.col == 3) ||
                (this.row == 3 && this.col == 4)){
            g.setColor(Color.GRAY);
            g.fillRect(tileX,tileY,this.tileSize, this.tileSize);
        }else {g.setColor(Color.white);
            g.fillRect(tileX,tileY,this.tileSize, this.tileSize);}
        //Rendering gray central dot
        g.setColor(Color.darkGray);
        g.fillOval(223,223,56, 56);

        //Rendering Guard pieces

        for(int i = 0; i <= 300; i+=100){
            g.setColor(Color.green);
            g.fillOval(i+25,25,56, 56);
            g.setColor(Color.yellow);
            g.fillOval(i + 28, 28, 50, 50);

            g.setColor(Color.yellow);
            g.fillOval(i+  125,425,56, 56);
            g.setColor(Color.green);
            g.fillOval(i + 128, 428, 50, 50);

        }
        //Rendering Leader Pieces
        g.setColor(Color.green);
        g.fillRect(0 + 28,400 + 28,50, 50);

        g.setColor(Color.yellow);
        g.fillRect(400 + 28,4 + 28,50, 50);



    }



}
