package gui.components;

import gameEngines.TextParser;
import gui.AbstractPanelCreator;
import gui.MainDisplay;
import models.Player;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInputPanel extends AbstractPanelCreator {
    private final MainDisplay mainDisplay;
    private TextParser textParser;
    private Player player;
    public UserInputPanel(String thisLabel, MainDisplay mainDisplay) {
        super(thisLabel);
        this.mainDisplay = mainDisplay;
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        JPanel panel = super.newPanel(player, x, y, width, height);
        setPlayer(player);

        // Set layout to FlowLayout with center alignment
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add user text input field
        JTextField userInput = new JTextField();
        userInput.setColumns(20); // Customize column size as needed
        textParser = new TextParser(mainDisplay);

        userInput.addActionListener(e -> {
            String userText = userInput.getText();
            textParser.textParser(userText, player);
            userInput.setText("");
        });

        System.out.println(player.getCurrentLocation());
        userInput.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent k) {
                switch (k.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_NUMPAD8: textParser.textParser("go north", getPlayer()); break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_NUMPAD2: textParser.textParser("go south", getPlayer()); break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_NUMPAD4: textParser.textParser("go west", getPlayer()); break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_NUMPAD6: textParser.textParser("go east", getPlayer()); break;
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        panel.add(userInput, BorderLayout.CENTER);

        return panel;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}