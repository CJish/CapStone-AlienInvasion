package Screens;

import utils.asciiPanels.AsciiPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public interface Screen {
    public void displayOutput(AsciiPanel a);

    public Screen respondToUserInput(KeyEvent k);
}