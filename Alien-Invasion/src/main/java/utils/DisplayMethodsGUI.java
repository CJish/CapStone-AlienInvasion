package utils;

import models.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class DisplayMethodsGUI {
    public static void hidePanel(JPanel panel) {
        if (panel.isVisible()) {
            panel.setVisible(false);
        } else {
            panel.setVisible(true);
        }
    }

    public static void keyPressedHandler(KeyEvent k, Player player) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4:
                UtilFunctions.movePosition("west", player);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6:
                UtilFunctions.movePosition("east", player);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_NUMPAD8:
                UtilFunctions.movePosition("north", player);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_NUMPAD2:
                UtilFunctions.movePosition("south", player);
                break;
        }
    }
}