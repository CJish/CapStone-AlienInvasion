package models;

import java.awt.*;
import java.util.ArrayList;

public class World {

    private Tile[][] tiles;
    private int width;
    private int height;
//    List<Creature> creatures = new ArrayList<Creature>();

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
//        this.creatures = new ArrayList();
    }

    // checks if the passed x, y coords are in bounds
    // if yes, then passes the tile object at that coord
    public Tile tile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return Tile.BOUNDS;
        } else {
            return tiles[x][y];
        }
    }

    // returns the symbol for what's at the given x,y coords
    public char symbol(int x, int y) {
        return tile(x, y).getSymbol();
    }

    // returns the color of the whatever is at tile x,y
    public Color color(int x, int y) {
        return tile(x, y).getColor();
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}