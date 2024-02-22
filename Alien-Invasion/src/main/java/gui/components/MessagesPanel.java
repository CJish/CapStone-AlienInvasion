package gui.components;

import Interfaces.ChangeListener;
import gameEngines.JsonReader;
import gui.AbstractPanelCreator;
import models.Location;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties

public class MessagesPanel extends AbstractPanelCreator implements ChangeListener {
    private JLabel label; // Define label as a field
    private JTextArea description;

    public MessagesPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        super.newPanel(player, x, y, width, height);

        // Use BorderLayout for the panel
        setLayout(new BorderLayout());

        // Create and add the title label at the top
        JLabel titleLabel = new JLabel(getjLabelString());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the title label
        add(titleLabel, BorderLayout.NORTH);

        // Create and customize the label for current location
        label = new JLabel("Current Location: " + player.getCurrentLocation());
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.RED);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the label for current location to the bottom left of the panel
        add(label, BorderLayout.SOUTH);

        // Create and customize the JTextArea for location description
        description = new JTextArea();
        description.setBackground(Color.DARK_GRAY);
        description.setForeground(Color.WHITE);
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setLineWrap(true); // Enable line wrapping
        description.setWrapStyleWord(true); // Wrap at word boundaries

        // Fetch and display the location description based on the player's current location
        updateLocationDescription(player.getCurrentLocation());
        DisplayMethodsGUI.currentLocationNPCs(player.getCurrentLocation(), description);
        JScrollPane scrollPane = new JScrollPane(description); // Wrap the JTextArea in a JScrollPane
        scrollPane.setBorder(null); // Remove the border of the scroll pane

        add(scrollPane, BorderLayout.CENTER); // Add the JScrollPane to the center of the panel

        return this;
    }

    // Method to update the displayed location
    public void updateLocation(String location) {
        label.setText("Current Location: " + location);
        updateLocationDescription(location); // Update the location description when the location changes
    }

    // Method to update the location description based on the given location
    private void updateLocationDescription(String location) {
        Location locationObj = JsonReader.getLocationByName(location);
        if (locationObj != null) {
            description.setText(locationObj.getDescription());
        } else {
            description.setText("Location information cannot be found");
        }
    }

    @Override
    public void onLocationChanged(String newLocation) {
        updateLocation(newLocation);
    }
}