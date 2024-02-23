package gui;

import gui.components.*;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameDisplayLayeredPane extends JLayeredPane implements KeyListener {

    public GameDisplayLayeredPane(Player player) {
        setPreferredSize(new Dimension(1024, 768));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        initializeComponents(player);
//        paintPlayerOnMap(player);
    }

    private void initializeComponents(Player player) {
        setLayout(null); // We'll use absolute positioning

        // Map screen area
        JPanel mapScreenPanel = new MapScreenPanel("", player).newPanel(player, 5, 5, 1000, 750);
        add(mapScreenPanel);
        // don't think this is needed; test and try
        Graphics g = new MapScreenPanel("", player).newPanel(player,0,0,0,0).getGraphics();

        // User input panel
        JPanel userInputPanel = new UserInputPanel("Your command: ").newPanel(player, 5, 760, 1000, 26 );
        DisplayMethodsGUI.GUItextInput(userInputPanel, player, 90);
        add(userInputPanel);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 5,791,200,200);
        add(playerStatusPanel);

        // Messages panel
        MessagesPanel messagesPanel = new MessagesPanel("Messages: ");
        messagesPanel.newPanel(player, 214,791, 590,200);
        add(messagesPanel);
        player.setChangeListener(messagesPanel);

        // Inventory panel
        InventoryPanel inventoryPanel = new InventoryPanel("Inventory: ");
        inventoryPanel.newPanel(player, 814, 791, 190, 200);
        add(inventoryPanel);
        player.setInventoryChangeListener(inventoryPanel);

        // Help panel (invisible by default)
        JPanel helpPopupPanel = new HelpPopUpPanel("Help: ").newPanel(player, 5, 5, 1000, 750);
        add(helpPopupPanel);
        helpPopupPanel.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}