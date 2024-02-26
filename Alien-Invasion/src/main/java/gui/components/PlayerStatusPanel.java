package gui.components;

import Interfaces.ChangeListener;
import gameEngines.JsonReader;
import gui.AbstractPanelCreator;
import models.Location;
import models.Player;

import javax.swing.*;
import java.awt.*;


// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties
public class PlayerStatusPanel extends AbstractPanelCreator implements ChangeListener {

    private JTextArea description;

    public PlayerStatusPanel(String thisLabel) {
        super(thisLabel);
        this.setBackground(Color.BLACK);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        super.newPanel(player, x, y, width, height);
        // Use BorderLayout for the panel
        setLayout(new BorderLayout());
        // Create and customize the JTextArea for location description
        description = new JTextArea();
        description.setBackground(Color.DARK_GRAY);
        description.setForeground(Color.WHITE);
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setLineWrap(true); // Enable line wrapping
        description.setWrapStyleWord(true); // Wrap at word boundaries

        add(description);

        updateLocation(player.getCurrentLocation(), player.getNpcDialouge());
        return this;
    }

    public void updateLocation(String location, String npcDialogue) {
        description.setText("Alerts: \n");
        updateLocationDescription(npcDialogue); // Update the location description with NPC dialogue
    }

    // Method to update the location description based on the given NPC dialogue
    private void updateLocationDescription(String npcDialogue) {
        description.append("\n" + npcDialogue);
    }

    @Override
    public void onChange() {
        Player player = super.getPlayer();
        updateLocation(player.getCurrentLocation(), player.getNpcDialouge());
    }
}