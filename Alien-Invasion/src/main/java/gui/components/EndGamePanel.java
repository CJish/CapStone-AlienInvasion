package gui.components;

import gui.AbstractPanelCreator;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGamePanel extends AbstractPanelCreator {

    public EndGamePanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        JPanel panel = super.newPanel(player, x, y, width, height);

        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(1,1,1,1));
        setLayout(new BorderLayout(0,0));

        // The actual end game button
        JButton endGameButton = super.returnButton("End Game", 200, 200);
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add the end game button to the center of the main panel
        panel.add(endGameButton, BorderLayout.CENTER);

        return panel;
    }
}
