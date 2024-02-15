package Screens;

import gameEngines.WorldBuilder;
import models.World;
import utils.asciiPanels.AsciiPanel;

import java.awt.event.KeyEvent;
import java.util.List;

public class PlayScreen implements Screen {
    private World world;
    private int centerX; // the horizontal center of the view screen
    private int centerY; // the vertical center of the view screen
//    private Creature player;

    private int screenWidth;
    private int screenHeight;

    private List<String> messages;

    public PlayScreen() {
        screenWidth = 160; // sets the width of the display screen
        screenHeight = 42; // sets the height of the display screen
        createWorld();
    }

    private void createWorld() {
        world = new WorldBuilder(180, 62).build();
    }

    // this controls how far along the x-axis we can scroll to prevent...you.
    // from scrolling too far and not finding the game world again.
    public int getMaxScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
    }

    // this does what getMaxScrollX() does, but for the y-axis
    public int getMaxScrollY() {
        return Math.max(0, Math.min(centerY - screenWidth / 2, world.getHeight() - screenHeight));
    }

    // this actually controls scrolling, takes the maxScroll methods
    // and is used to respond to the user's input
    private void scrollBy(int x, int y) {
        // uses the largest of (0 || (the lowest of (centerX + x, worldWidth))
        // don't worry, this one took me a while
        centerX = Math.max(0, Math.min(centerX + x, world.getWidth()));
        centerY = Math.max(0, Math.min(centerY + y, world.getHeight()));
    }

    // left and top because that's where the display panel starts building
    // just like writing a book, you start at the top left, work right and then down
    private void displayTiles(AsciiPanel a, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                a.write(world.symbol(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }

    // used
    public void displayOutput(AsciiPanel a) {
        int left = getMaxScrollX();
        int top = getMaxScrollY();
        displayTiles(a, left, top);
        a.write("Player Status: ", 1, 44);
    }

    public Screen respondToUserInput(KeyEvent k) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4: scrollBy(-1, 0); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6: scrollBy(1, 0); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_NUMPAD2: scrollBy(0, 1); break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_NUMPAD8: scrollBy(0, -1); break;
        }
        return this;
    }

}