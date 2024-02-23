package gui.components;

import Interfaces.ChangeListener;
import gui.AbstractPanelCreator;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import java.awt.*;

public class CurrentLocationNPCPanel extends AbstractPanelCreator implements ChangeListener {
    public static JTextArea characters;

    public CurrentLocationNPCPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        super.newPanel(player, x, y, width, height);

        // Create and customize the JTextArea for location description
        characters = new JTextArea();
        characters.setBackground(Color.DARK_GRAY);
        characters.setForeground(Color.white);
        characters.setFont(new Font("Arial", Font.PLAIN, 16));
        characters.setEditable(false);

        DisplayMethodsGUI.currentLocationNPCs(player.getCurrentLocation(), characters);

        JScrollPane scrollPane = new JScrollPane(characters);
        scrollPane.setBorder(null);

        onLocationChanged(player.getCurrentLocation());

        add(scrollPane);
        return this;
    }

    @Override
    public void onLocationChanged(String newLocation) {
        DisplayMethodsGUI.currentLocationNPCs(newLocation, characters);
    }
}