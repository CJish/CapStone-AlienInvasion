package gameEngines;

import models.Tile;
import models.World;

public class WorldBuilder {

    // Tile[x][y] where x and y correspond to the x and y axes of a traditional graph
    // except the graph starts at the top and grows down and to the right
    /*          x-axis
              0 1 2 3 4 5 6 7 ...
              _ _ _ _ _ _ _ _ _>
            0|X       Y
         y  1|
            2|
         a  3|
         x  4|    Z
         i  5|
         s  6|
             V
       so the Tile[0][0] is X, Tile[4][0] is Y, and Tile[2][4] is Z
     */
    private Tile[][] tiles;
    private int width;
    private int height;


    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    // builds a world with tile objects
    public World build() {
        return new World(tiles);
    }

}