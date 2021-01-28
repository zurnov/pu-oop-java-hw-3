package Game;

import Piece.GuardPiece;
import Piece.LeaderPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class GameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 5;
        private Object[][] pieceCollection;
        private Object selectedPiece;

    public  GameBoard(){
        this.pieceCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        this.pieceCollection[1][0] = new GuardPiece(0,0,Color.GREEN);
        this.pieceCollection[1][1] = new GuardPiece(0,1,Color.GREEN);
        this.pieceCollection[1][2] = new GuardPiece(0,2,Color.GREEN);
        this.pieceCollection[1][3] = new GuardPiece(0,3,Color.GREEN);

        this.pieceCollection[3][0] = new GuardPiece(4,1,Color.YELLOW);
        this.pieceCollection[3][1] = new GuardPiece(4,2,Color.YELLOW);
        this.pieceCollection[3][2] = new GuardPiece(4,3,Color.YELLOW);
        this.pieceCollection[3][3] = new GuardPiece(4,4,Color.YELLOW);

        //this.pieceCollection[1][4] = new LeaderPiece(4,0,Color.GREEN);
        //this.pieceCollection[3][4] = new LeaderPiece(0,4,Color.YELLOW);


        this.setSize(500,500+GameTile.extraSpace);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);


    }
    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());

        if(this.selectedPiece != null){
            GuardPiece guardPiece = (GuardPiece)this.selectedPiece;
            guardPiece.move(row,col);
            this.selectedPiece = null;
            this.repaint();
        }

        if(this.hasBoardPiece(row,col)) {
            this.selectedPiece = this.getBoardPiece(row, col);
        }
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
    public void paint(Graphics g) {

        GameTile gameTile = new GameTile(4, 4);
        gameTile.render(g);
        for(int row = 0; row < 4;row++){

            for(int col = 0; col < 4;col++) {

                this.renderGamePiece(g, row, col);
            }
        }

    }
    private void renderGamePiece(Graphics g, int row,int col){
        if(this.hasBoardPiece(row,col)){
            GuardPiece p =  (GuardPiece) this.getBoardPiece(row,col);
            p.render(g);
        }



    }
    private Object getBoardPiece(int row,int col){
        return this.pieceCollection[row][col];
    }
    private boolean hasBoardPiece(int row,int col){
        return this.getBoardPiece(row,col) != null;
    }
private int getBoardDimensionBasedOnCoordinates(int coordinates){
        return coordinates / GameTile.TILE_SIZE;
}

}


