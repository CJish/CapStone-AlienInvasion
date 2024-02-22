package gui;

import gameEngines.JsonReader;
import gui.components.*;
import models.Location;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameDisplay extends JPanel implements KeyListener {

    public GameDisplay(Player player) {
        setPreferredSize(new Dimension(1024, 800));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initializeComponents(player);
    }

    private void initializeComponents(Player player) {
        setLayout(null); // We'll use absolute positioning

        // Map screen area
        JPanel mapScreenPanel = new MapScreenPanel("").newPanel(player, 805, 5, 1000, 750);
        add(mapScreenPanel);

        JPanel userInputPanel = new UserInputPanel("Your command: ").newPanel(player, 805, 760, 1000, 35 );
//        DisplayMethodsGUI.GUItextInput(userInputPanel, player, 90);
         add(userInputPanel);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 805,800,200,200);
        add(playerStatusPanel);

        // Messages panel
        MessagesPanel messagesPanel = new MessagesPanel("Messages: ");
        messagesPanel.newPanel(player, 1014,800, 590,200);
        add(messagesPanel);
        player.setChangeListener(messagesPanel);

        // Inventory panel
        InventoryPanel inventoryPanel = new InventoryPanel("Inventory: ");
        inventoryPanel.newPanel(player, 1614, 800, 190, 200);
        add(inventoryPanel);
        player.setInventoryChangeListener(inventoryPanel);
    }


    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}