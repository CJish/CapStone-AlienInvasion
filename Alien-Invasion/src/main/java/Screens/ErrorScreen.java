package Screens;

import utils.asciiPanels.AsciiPanel;

import java.awt.event.KeyEvent;

public class ErrorScreen implements Screen {

    public void displayOutput(AsciiPanel a) {
        a.writeCenter("There was an error", 18);
        a.writeCenter("== Press [esc] to return to the start screen ==", 22);
    }

    public Screen respondToUserInput(KeyEvent k) {
        if (k.getKeyCode() == KeyEvent.VK_ESCAPE) {
            return new StartScreen();
        }
        else return null;
    }

}