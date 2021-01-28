package Game;

import Piece.GuardPiece;
import Piece.LeaderPiece;
import Piece.Turtles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class GameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 5;
        private Object[][] pieceCollection;
        private Object selectedPiece;
        public int numOne;
        public int numTwo;

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

        // this.pieceCollection[1][4] = new LeaderPiece(4,0,Color.GREEN);
        //this.pieceCollection[3][4] = new LeaderPiece(0,4,Color.YELLOW);

        //this.pieceCollection[randomTurtleGenerator()][2] = new Turtles(2,randomTurtleGenerator(),Color.red);

        this.setSize(500,500+GameTile.EXTRA_SPACE);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
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
    /**
     * Method that paints the board with the pieces and Board's grid
     */
    public void paint(Graphics g) {

        GameTile gameTile = new GameTile(5, 5);
        gameTile.render(g);
        for(int row = 0; row < 5;row++){

            for(int col = 0; col < 5;col++) {

                this.renderGamePiece(g, row, col);

            }
        }
        paintTurtles(g);

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

    public int randomTurtleGenerator(){
        Random random = new Random();
        int numOne = random.nextInt(5);
        while(numOne == 2){
            numOne = random.nextInt(5);
        }

        return numOne;
    }
    private void renderTurtle(Graphics g){
        int numOne= randomTurtleGenerator();
        int numTwo= randomTurtleGenerator();
        Random random = new Random();
        g.setColor(Color.red);
        g.fillOval(100*numOne,225,50,50);


    }
    private void paintTurtles(Graphics g){
        for(int row = 0;row < 2;row++){
            renderTurtle(g);

        }
    }
    
}


