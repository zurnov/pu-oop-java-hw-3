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

    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }

    public void render(Graphics g) {

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE + GameTile.EXTRA_SPACE;

        g.setColor(this.color);
        g.fillRect(x+GameTile.EXTRA_SPACE,y+GameTile.EXTRA_SPACE,60, 60);

    }

    public void move(int row,int col){
        this.row= row;
        this.col = col;
    }
    public  void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(400,0+GameTile.EXTRA_SPACE,60,60);
    }

}
