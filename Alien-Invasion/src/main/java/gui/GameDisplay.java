package gui;

import gameEngines.JsonReader;
import gui.components.*;
import models.Location;
import models.Player;
import utils.DisplayMethodsGUI;
import utils.UtilFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GameDisplay extends JLayeredPane {

    public GameDisplay(Player player) {
        setPreferredSize(new Dimension(1024, 1024));
        setBackground(Color.BLACK);
        setFocusable(true);
        initializeComponents(player);
    }

    private void initializeComponents(Player player) {

        setLayout(null); // We'll use absolute positioning

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setSize(new Dimension(1024, 1024));
        backgroundPanel.setBackground(Color.BLACK);
        add(backgroundPanel, DEFAULT_LAYER);

        // Map screen area
        JPanel mapScreenPanel = new MapScreenPanel("", player).newPanel(player, 5, 5, 800, 750);
        add(mapScreenPanel, JLayeredPane.MODAL_LAYER);
//        mapScreenPanel.setVisible(false);

        // User input panel
        JPanel userInputPanel = new UserInputPanel("").newPanel(player, 5, 760, 1000, 30);
        userInputPanel.setBackground(Color.CYAN);
        userInputPanel.setVisible(true);
        DisplayMethodsGUI.GUItextInput(userInputPanel, player, 30);
        add(userInputPanel, JLayeredPane.DRAG_LAYER);
//        userInputPanel.setVisible(false);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 5,791,200,200);
        add(playerStatusPanel, JLayeredPane.MODAL_LAYER);
//        playerStatusPanel.setVisible(false);

        // Messages panel
        MessagesPanel messagesPanel = new MessagesPanel("Messages: ");
        messagesPanel.newPanel(player, 214,791, 590,200);
        add(messagesPanel, JLayeredPane.MODAL_LAYER);
        player.setChangeListener(messagesPanel);
//        messagesPanel.setVisible(false);

        // Inventory panel
        InventoryPanel inventoryPanel = new InventoryPanel("Inventory: ");
        inventoryPanel.newPanel(player, 814, 791, 190, 200);
        add(inventoryPanel, JLayeredPane.MODAL_LAYER);
        player.setInventoryChangeListener(inventoryPanel);
//        inventoryPanel.setVisible(false);

        CurrentLocationItemsPanel itemsPanel = new CurrentLocationItemsPanel("Items Nearby:");
//        inventoryPanel.setVisible(false);

        // Help panel (pops up on clicking the help button)
        JPanel helpPopupPanel = new HelpPopUpPanel("Help: ").newPanel(player, 5, 5, 900, 750);
        add(helpPopupPanel, JLayeredPane.DRAG_LAYER);
        helpPopupPanel.setVisible(false);

        // Panel to hold the help button
        JPanel helpButtonPanel = new HelpButtonPanel("").newPanel(player, 805, 0, 200, 100);
        add(helpButtonPanel, JLayeredPane.MODAL_LAYER);

        // The actual help button
        JButton helpButton = new JButton("HELP");
        helpButton.setPreferredSize(new Dimension(200, 100));

        helpButtonPanel.add(helpButton);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayMethodsGUI.hidePanel(helpPopupPanel);
            }
        });
    }
}