package gui;

import app.AlienInvasionApp;
import models.Player;
import utils.EndGameCriteria;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utils.UtilFunctions.createColoredPanel;

public class MainDisplay extends JFrame implements KeyListener {

    private GameDisplay gameDisplay;
    private static EndGameDisplay endGameDisplay;

    // This is now the main class for the GUI, all child classes and methods should be appended here while we separate and update the game
    public void showMainDisplay(Player player) throws IOException {
        gameDisplay = new GameDisplay(player, this);
        endGameDisplay = new EndGameDisplay(player, player.isPlayerWon());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage alienSoldierBufferedImg = ImageIO.read(new File("static/alienSoldier.jpg"));
        int windowWidth = alienSoldierBufferedImg.getWidth() + 205;
        int windowHeight = alienSoldierBufferedImg.getHeight() + 20;
        setSize(windowWidth, windowHeight);
        setLayout(new BorderLayout());

        JLayeredPane layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        JButton button = new JButton("Click or Press [ENTER]");
        button.addActionListener(e -> clearTitleLoadGame());

        button.addKeyListener(this);

        button.setPreferredSize(new Dimension(windowWidth / 5, windowHeight / 10));

        JPanel panel1 = createColoredPanel(Color.BLACK, 0, 0, windowWidth, windowHeight);
        JPanel panel2 = createColoredPanel(Color.WHITE, windowWidth / 2 - 100, windowHeight / 2 - 100, windowWidth / 5, windowHeight / 12);

        panel1.setOpaque(false);
        panel2.setOpaque(false);

        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER);

        JLabel alienSoldierLabel = new JLabel(new ImageIcon(alienSoldierBufferedImg));
        panel1.add(alienSoldierLabel);
        panel2.add(button, BorderLayout.CENTER);

        setIconImage(alienSoldierBufferedImg);
        setVisible(true); // Make the frame visible
    }

    // clears the Title Screen and loads the Game Screen while passing in the same gameDisplay(player) that
    // was set in the first line of showMainDisplay()
    public void clearTitleLoadGame() {
        getContentPane().removeAll();
        getContentPane().add(gameDisplay);
        revalidate();
        repaint();
    }

    public void showEndGameDisplay(Player player, boolean playerwon) {
        this.getContentPane().removeAll();
        this.getContentPane().add(new EndGameDisplay(player, playerwon));
        this.revalidate();
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            clearTitleLoadGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}