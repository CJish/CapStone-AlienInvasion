package gui;

import client.PlayerLocation;
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
//        JPanel mapScreenPanel = new JPanel();
//        mapScreenPanel.setBounds(5, 5, 1000, 750);
//        mapScreenPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//        mapScreenPanel.setBackground(Color.DARK_GRAY);
        add(mapScreenPanel);

        // Player status panel
        JPanel playerStatusPanel = new PlayerStatusPanel("Player Status: ").newPanel(player, 5,760,200,200);
//        JPanel playerStatusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        playerStatusPanel.setBounds(5, 760, 200, 200);
//        playerStatusPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//        playerStatusPanel.setBackground(Color.LIGHT_GRAY);
        add(playerStatusPanel);

        // Messages & location panel
        JPanel messagesPanel = new MessagesPanel("Messages: ").newPanel(player, 214,760, 590,200);
//        messagesPanel.setBounds(214, 760, 590, 200);
//        messagesPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//        messagesPanel.setBackground(Color.LIGHT_GRAY);
        add(messagesPanel);

        // Inventory panel
        JPanel inventoryPanel = new InventoryPanel("Inventory: ").newPanel(player, 814, 760, 190, 200);
//        inventoryPanel.setBounds(814, 760, 190, 200);
//        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//        inventoryPanel.setBackground(Color.LIGHT_GRAY);
        add(inventoryPanel);

        // Title Label
//        JLabel titleLabel = new JLabel("Player Status");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        titleLabel.setForeground(Color.WHITE);
//        titleLabel.setBounds(350, 70, 300, 50);
//        playerStatusPanel.add(titleLabel);

        // Player Status Label
//        JLabel playerStatusLabel = new JLabel("Alien Invasion");
//        playerStatusLabel.setFont(new Font("Arial", Font.BOLD, 40));
//        playerStatusLabel.setForeground(Color.WHITE);
//        playerStatusLabel.setBounds(350, 70, 300, 50);
//        mapScreenPanel.add(playerStatusLabel);

        // Inventory Label
//        JLabel inventoryLabel = new JLabel("Inventory");
//        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        inventoryLabel.setForeground(Color.WHITE);
//        inventoryLabel.setBounds(350, 70, 300, 50);
//        inventoryPanel.add(inventoryLabel);

        // Message Label
//        JLabel textLabel = new JLabel("Messages");
//        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        textLabel.setForeground(Color.WHITE);
//        messagesPanel.add(textLabel); // Add to messagesPanel
    }



    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
