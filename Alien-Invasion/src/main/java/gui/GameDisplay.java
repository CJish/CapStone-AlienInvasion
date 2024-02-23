package gui;

import gameEngines.JsonReader;
import gui.components.*;
import models.Location;
import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GameDisplay extends JLayeredPane {

    public GameDisplay(Player player) {
        setPreferredSize(new Dimension(1229, 1034));
        setBackground(Color.BLACK);
        setFocusable(true);
        initializeComponents(player);
    }

    private void initializeComponents(Player player) {

        setLayout(null); // We'll use absolute positioning

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setSize(new Dimension(1229, 1034));
        backgroundPanel.setBackground(Color.BLACK);
        add(backgroundPanel, 0);

        // Map screen area
        JPanel mapScreenPanel = new MapScreenPanel("", player).newPanel(player, 5, 5, 800, 750);
        add(mapScreenPanel, JLayeredPane.PALETTE_LAYER);
//        mapScreenPanel.setVisible(false);

        // User input panel
        JPanel userInputPanel = new UserInputPanel("What is your command?").newPanel(player, 5, 760, 1000, 35);
        userInputPanel.setBackground(Color.BLACK);
        add(userInputPanel, JLayeredPane.DRAG_LAYER);
//        userInputPanel.setVisible(false);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 5,800,200,200);
        add(playerStatusPanel, JLayeredPane.MODAL_LAYER);
//        playerStatusPanel.setVisible(false);

        // Messages panel
        MessagesPanel messagesPanel = new MessagesPanel("Messages: ");
        messagesPanel.newPanel(player, 214,800, 590,200);
        add(messagesPanel, JLayeredPane.MODAL_LAYER);
        player.setChangeListener(messagesPanel);
//        messagesPanel.setVisible(false);

        // Inventory panel
        InventoryPanel inventoryPanel = new InventoryPanel("Inventory: ");
        inventoryPanel.newPanel(player, 814, 800, 190, 200);
        add(inventoryPanel, JLayeredPane.MODAL_LAYER);
        player.setInventoryChangeListener(inventoryPanel);
//        inventoryPanel.setVisible(false);

        // Items at current location panel
        CurrentLocationItemsPanel itemsPanel = new CurrentLocationItemsPanel("Items Nearby:");
        itemsPanel.newPanel(player, 1010, 5, 200, 200);

        add(itemsPanel, JLayeredPane.MODAL_LAYER);
//        itemsPanel.setVisible(false);

        // Panel displaying NPCs in the current location
        CurrentLocationNPCPanel npcPanel = new CurrentLocationNPCPanel("Characters Nearby:");
        npcPanel.newPanel(player, 1010, 210, 200, 200);
        add(npcPanel, JLayeredPane.MODAL_LAYER);
//        npcPanel.setVisible(false);

        // Help panel (pops up on clicking the help button)
        JPanel helpPopupPanel = new HelpPopUpPanel("Help: ").newPanel(player, 5, 5, 900, 750);
        add(helpPopupPanel, JLayeredPane.DRAG_LAYER);
        helpPopupPanel.setVisible(false); // leave false!!!!

        // Panel to hold the help button
        JPanel helpButtonPanel = new HelpButtonPanel("").newPanel(player, 1010, 892, 200, 100, helpPopupPanel);
        add(helpButtonPanel, JLayeredPane.MODAL_LAYER);
//        helpButtonPanel.setVisible(false);

        // Panel to display the timer
        JPanel timerPanel = new TimerPanel("TIME LEFT: ").newPanel(player, 1010, 415, 200, 200);
        add(timerPanel, MODAL_LAYER);
//        timerPanel.setVisible(true);
    }
}