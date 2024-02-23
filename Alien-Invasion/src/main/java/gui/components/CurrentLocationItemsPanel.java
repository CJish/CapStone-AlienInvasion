package gui.components;

import Interfaces.ChangeListener;
import Interfaces.InventoryChangeListener;
import gameEngines.JsonReader;
import gui.AbstractPanelCreator;
import models.Location;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CurrentLocationItemsPanel extends AbstractPanelCreator implements ChangeListener {
    private static JTextArea items;

    public CurrentLocationItemsPanel(String thisLabel ) {
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

        updateLocationItems(player.getCurrentLocation());

        JScrollPane scrollPane = new JScrollPane(items);
        scrollPane.setBorder(null);

        add(scrollPane);
        return this;
    }

    private void updateLocationItems(String location) {
        Location locationObj = JsonReader.getLocationByName(location);
        if (locationObj != null) {
            List<String> itemsList = locationObj.getItems();
            if (itemsList != null && !itemsList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String item : itemsList) {
                    sb.append(item).append("\n");
                }
                items.setText(sb.toString());
            } else {
                items.setText("No items found");
            }
        } else {
            items.setText("Location not found");
        }
    }

    @Override
    public void onChange() {
        updateLocationItems(super.getPlayer().getCurrentLocation());
    }
}