package gui.components;

import Interfaces.ChangeListener;
import gui.AbstractPanelCreator;
import models.Item;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties
// InventoryPanel.java
public class InventoryPanel extends AbstractPanelCreator implements ChangeListener {
    private JLabel titleLabel;

    public InventoryPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        JPanel panel = super.newPanel(player, x, y, width, height);

        // Add the title label to the panel
        titleLabel = addPanelTitleLabel();
        panel.add(titleLabel);

        // Update the inventory display
        updateInventory(player.getPlayerInventory());

        return panel;
    }

    @Override
    public void onInventoryChange(List<String> inventory) {
        updateInventory(inventory);
    }

    private void updateInventory(List<String> inventory) {
        // Clear existing inventory items
        removeAll();

        // Add the title label back to the panel
        add(titleLabel);

        // Set layout and background
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);

        // Add each inventory item to the panel
        for (String item : inventory) {
            JLabel itemLabel = new JLabel(item);
            itemLabel.setForeground(Color.WHITE);
            add(itemLabel);
        }

        revalidate(); // Refresh the layout
        repaint(); // Repaint the panel
    }

    @Override
    public void onLocationChanged(String newLocation) {
        // Do nothing, not needed in this class
    }
}