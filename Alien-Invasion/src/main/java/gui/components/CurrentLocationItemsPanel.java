package gui.components;

import Interfaces.ChangeListener;
import Interfaces.InventoryChangeListener;
import gui.AbstractPanelCreator;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CurrentLocationItemsPanel extends AbstractPanelCreator implements ChangeListener, InventoryChangeListener {
    public static JTextArea items;

    public CurrentLocationItemsPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        super.newPanel(player, x, y, width, height);

        // Create and customize the JTextArea for location description
        items = new JTextArea();
        items.setBackground(Color.DARK_GRAY);
        items.setForeground(Color.white);
        items.setFont(new Font("Arial", Font.PLAIN, 16));
        items.setEditable(false);
        items.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(items);
        scrollPane.setBorder(null);

        onLocationChanged(player.getCurrentLocation());
        onInventoryChange(player.getPlayerInventory());

        add(scrollPane);
        return this;
    }

    @Override
    public void onLocationChanged(String newLocation) {
        DisplayMethodsGUI.currentLocationItems(newLocation, items);
    }

    @Override
    public void onInventoryChange(List<String> inventory) {
        int i = 0;
        for (String item : inventory) {
            DisplayMethodsGUI.currentLocationItems(item, items);
            i++;
        }

    }
}