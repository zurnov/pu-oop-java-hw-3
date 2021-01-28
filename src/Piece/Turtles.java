package Piece;

import Game.GameTile;

import java.awt.*;

public class Turtles {
    private int row;
    private int col;
    private Color color;

    public Turtles(int row,int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;

    }
    public void render(Graphics g) {

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE + GameTile.EXTRA_SPACE;

        g.setColor(this.color);
        g.fillOval(x+GameTile.EXTRA_SPACE,y+GameTile.EXTRA_SPACE,50, 50);

    }

}
