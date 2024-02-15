package Screens;

import utils.asciiPanels.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel a) {
        a.write("Alien Invasion", 1, 1);
        // TODO: change this to a button
        a.writeCenter("== press [enter] to start ==", 22);
    }

    public Screen respondToUserInput(KeyEvent k) {
        if (k.getKeyCode() == KeyEvent.VK_ENTER) {
            return new PlayScreen();
        }
        return null;
    }
}