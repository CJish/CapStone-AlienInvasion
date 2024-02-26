package gui;

import gui.components.EndGamePanel;
import models.Player;
import utils.EndGameCriteria;

import javax.swing.*;
import java.awt.*;

public class EndGameDisplay extends JLayeredPane {
    public EndGameDisplay(Player player, boolean playerwon) {
        setPreferredSize(new Dimension(1229, 1034));
        setBackground(Color.BLACK);
        setFocusable(true);
        initializeComponents(player, playerwon);
    }

    private void initializeComponents(Player player, boolean playerwon) {
        setLayout(null); // We'll use absolute positioning

        // Background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setSize(new Dimension(1229, 1034));
        backgroundPanel.setBackground(Color.BLACK);
        add(backgroundPanel, DEFAULT_LAYER);

        // Game Over label
        JLabel label = new JLabel("GAME OVER");
        label.setFont(new Font("Arial", Font.BOLD, 80));
        label.setForeground(Color.WHITE);

        // Calculate position to center the label horizontally and place it at the top
        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height;
        int xLabel = 250; // Center horizontally
        int yLabel = 50; // Top margin

        // Set bounds for the label
        label.setBounds(xLabel, yLabel, labelWidth, labelHeight);
        add(label, JLayeredPane.PALETTE_LAYER); // Add to the highest layer

        String didPlayerWin;
        System.out.println("Player won: " + player.isPlayerWon());
        if(playerwon) {
            didPlayerWin = "You Won";
            System.out.println("Player won: " + player.isPlayerWon());
        } else {
            didPlayerWin = "You Lost";
            System.out.println("Player won: " + player.isPlayerWon());
        }

        JLabel winner = new JLabel(didPlayerWin);
        winner.setFont(new Font("Arial", Font.BOLD, 80));
        winner.setForeground(Color.WHITE);

        // Calculate position to center the label horizontally and place it at the top
        int labelWidthWin = label.getPreferredSize().width;
        int labelHeightWin = label.getPreferredSize().height;
        int xLabelWin = 250; // Center horizontally
        int yLabelWin = 150; // Top margin

        // Set bounds for the label
        winner.setBounds(xLabelWin, yLabelWin, labelWidthWin, labelHeightWin);
        add(winner, JLayeredPane.PALETTE_LAYER); // Add to the highest layer

        // End Game panel
        JPanel endGamePanel = new EndGamePanel("GAME OVER").newPanel(player, 325, 400, 590, 200);
        add(endGamePanel, JLayeredPane.MODAL_LAYER);

        // Refresh the layout
        revalidate();
        repaint();
    }
}
