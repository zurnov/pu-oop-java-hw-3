package Game;

import Piece.LeaderPiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JFrame{
    private ArrayList<Object> pieceCollection;

    public  GameBoard(){


        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public void paint(Graphics g) {

        super.paint(g);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                GameTile tile = new GameTile(row, col);
                tile.render(g);


            }
        }





        }
    }
