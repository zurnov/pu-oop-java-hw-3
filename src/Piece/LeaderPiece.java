package Piece;

import Game.GameTile;

import java.awt.*;
//TODO
public class LeaderPiece {
    private int row;
    private int col;
    private Color color;

    public LeaderPiece(int row,int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;

    }
//    public boolean isMoveValid(int moveRow,int moveCol){
//        int rowCoefficient = Math.abs(moveRow - this.row);
//        int colCoefficient = moveCol - this.col;
//
//        return  rowCoefficient == 1 &&
//                colCoefficient == 0;
//
//    }
    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }

    public void render(Graphics g) {

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE + GameTile.extraSpace;

        g.setColor(this.color);
        g.fillRect(x+GameTile.extraSpace,y+GameTile.extraSpace,60, 60);

    }

    public void move(int row,int col){
        this.row= row;
        this.col = col;
    }

}
