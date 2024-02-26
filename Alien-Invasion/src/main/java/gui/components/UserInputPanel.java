package gui.components;

import gameEngines.TextParser;
import gui.AbstractPanelCreator;
import gui.MainDisplay;
import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputPanel extends AbstractPanelCreator {
    private final MainDisplay mainDisplay;
    private TextParser textParser;
    public UserInputPanel(String thisLabel, MainDisplay mainDisplay) {
        super(thisLabel);
        this.mainDisplay = mainDisplay;
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        JPanel panel = super.newPanel(player, x, y, width, height);

        // Set layout to FlowLayout with center alignment
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add user text input field
        JTextField userInput = new JTextField();
        userInput.setColumns(20); // Customize column size as needed

        userInput.addActionListener(e -> {
            textParser = new TextParser(mainDisplay);
            String userText = userInput.getText();
            textParser.textParser(userText, player);
            userInput.setText("");
        });

        panel.add(userInput, BorderLayout.CENTER);

        return panel;
    }
}