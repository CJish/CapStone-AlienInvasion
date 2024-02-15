package controller;

import Screens.Screen;
import Screens.StartScreen;

import javax.swing.*;

import app.AlienInvasionApp;
import utils.asciiPanels.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller extends JFrame implements KeyListener {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Alien Invasion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1024, 768));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private AsciiPanel terminal;
    private Screen screen;

    public Controller() {
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args){
        AlienInvasionApp app = new AlienInvasionApp();
        app.run();

        // currently not working because there's an issue with setting the font
//        Controller app = new Controller();
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        app.setVisible(true);

        // TODO: we'll have to do some work in order to get everything running in the GUI
        // this simply pops up a new screen
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}