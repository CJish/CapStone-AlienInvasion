package app;

import client.*;
import gameEngines.JsonWriter;
import models.Player;
import gameEngines.TextParser;
import utils.UtilFunctions;
import utils.asciiPanels.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class AlienInvasionApp extends JFrame implements KeyListener {

    private AsciiPanel terminal;

    private final Player player = new Player();
    private boolean isGame = true;

    public void run() {
        initialize();
        UtilFunctions.clear();
        Scanner scan = new Scanner(System.in);
        TitleScreen.displayAsciiArt("./static/title.txt");

        if (NewGame.gameStart()) {
            UtilFunctions.clear();
            while (isGame) {
                AlienInvasionIntro.clearConsolePause(1000);
                UtilFunctions.displayCharacterStatus(player);
                System.out.println("What's your next move Commander?");
                System.out.print("> ");
                String userInput = scan.nextLine().trim();
                TextParser.textParser(userInput, player);
            }
        }
    }

    public static void createAndShowGUI() {
        JFrame jFrame = new JFrame(); // creating an instance of JFrame
        JButton jButton = new JButton("Alien Invasion"); // creating a button instance
        jButton.setBounds(230, 100, 200, 40); // defining the button x,y, width, height

        jFrame.add(jButton);
        jFrame.setSize(800, 400);
        jFrame.setLayout(null); // we could use a layout manager, null for now
        jFrame.setVisible(true); // invisible by default
    }

    public void initialize() {
        player.setX(0);
        player.setY(0);
        player.setCurrentLocation("Command Center");
        player.setHealth(100);
        JsonWriter.resetLocationsJSON();
    }

    public void buttonClicked(KeyEvent k) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }

}