package gui.components;

import gameEngines.TextParser;
import gui.AbstractPanelCreator;
import models.Player;
import utils.UtilFunctions;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInputPanel extends AbstractPanelCreator {
    public UserInputPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        JPanel panel = super.newPanel(player, x, y, width, height);

        // Set layout to FlowLayout with center alignment
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add user text input field
        JTextField userInput = new JTextField();
        userInput.setColumns(20); // Customize column size as needed

        userInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userInput.getText();
                TextParser.textParser(userText, player);
                userInput.setText("");
            }
        });

        userInput.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent k) {
                switch (k.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_NUMPAD8: TextParser.textParser("go north", player); break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_NUMPAD2: TextParser.textParser("go south", player); break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_NUMPAD4: TextParser.textParser("go west", player); break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_NUMPAD6: TextParser.textParser("go east", player); break;
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
}