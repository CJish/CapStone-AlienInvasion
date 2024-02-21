package gui;

import gui.components.InventoryPanel;
import gui.components.MapScreenPanel;
import gui.components.MessagesPanel;
import gui.components.PlayerStatusPanel;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameDisplay extends JPanel implements KeyListener {

    public GameDisplay(Player player) {
        setPreferredSize(new Dimension(1024, 768));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initializeComponents(player);
    }

    private void initializeComponents(Player player) {
        setLayout(null); // We'll use absolute positioning

        // Map screen area
        JPanel mapScreenPanel = new MapScreenPanel("").newPanel(player, 5, 5, 1000, 750);
        add(mapScreenPanel);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 5,760,200,200);
        add(playerStatusPanel);

        // Messages panel
        MessagesPanel messagesPanel = new MessagesPanel("Messages: ");
        messagesPanel = (MessagesPanel) messagesPanel.newPanel(player, 214,760, 590,200); // Cast the panel to MessagesPanel
        add(messagesPanel);
        player.setChangeListener(messagesPanel);

        // Inventory panel
        InventoryPanel inventoryPanel = new InventoryPanel("Inventory: ");
        inventoryPanel = (InventoryPanel) inventoryPanel.newPanel(player, 814, 760, 190, 200); // Cast the panel to InventoryPanel
        add(inventoryPanel);
        player.setChangeListener(inventoryPanel);
    }


    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}