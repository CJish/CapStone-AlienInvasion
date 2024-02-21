package gui.components;

import Interfaces.ChangeListener;
import gui.AbstractPanelCreator;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties

public class MessagesPanel extends AbstractPanelCreator implements ChangeListener {
    private JLabel label; // Define label as a field

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
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the label for current location to the bottom left of the panel
        add(label, BorderLayout.SOUTH);

        return this;
    }

    // Method to update the displayed location
    public void updateLocation(String location) {
        label.setText("Current Location: " + location);
    }

    @Override
    public void onLocationChanged(String newLocation) {
        updateLocation(newLocation);
    }

    @Override
    public void onInventoryChange(List<String> inventory) {
        //Do Nothing with this, it must be present via the interface
    }
}