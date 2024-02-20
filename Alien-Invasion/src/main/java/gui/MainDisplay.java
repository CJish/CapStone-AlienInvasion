package gui;

import models.Player;

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
    // This is now the main class for the GUI, all child classes and methods should be appended here while we separate and update the game
    public void showMainDisplay(Player player) throws IOException {
        GameDisplay gameDisplay = new GameDisplay(player);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage alienSoldierBufferedImg = ImageIO.read(new File("static/alienSoldier.jpg"));
        int windowWidth = alienSoldierBufferedImg.getWidth();
        int windowHeight = alienSoldierBufferedImg.getHeight();
        setSize(windowWidth, windowHeight);
        setLayout(new BorderLayout());

        JLayeredPane layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        JButton button = new JButton("Click to play Alien Invasion");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(gameDisplay);
                revalidate();
                repaint();
            }
        });

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

    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
