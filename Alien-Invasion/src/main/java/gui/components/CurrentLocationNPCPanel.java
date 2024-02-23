package gui.components;

import Interfaces.ChangeListener;
import gameEngines.JsonReader;
import gui.AbstractPanelCreator;
import models.Location;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

        JScrollPane scrollPane = new JScrollPane(characters);
        scrollPane.setBorder(null);
        updateLocationCharacters(player.getCurrentLocation());
        add(scrollPane);
        return this;
    }

    private void updateLocationCharacters(String location) {
        Location locationObj = JsonReader.getLocationByName(location);
        if (locationObj != null) {
            List<String> charactersList = locationObj.getCharacters();
            if (charactersList != null && !charactersList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String item : charactersList) {
                    sb.append(item).append("\n");
                }
                characters.setText(sb.toString());
            } else {
                characters.setText("No characters found");
            }
        } else {
            characters.setText("Location not found");
        }
    }

    @Override
    public void onChange() {
        updateLocationCharacters(super.getPlayer().getCurrentLocation());
    }
}