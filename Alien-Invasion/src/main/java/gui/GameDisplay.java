package gui;

import client.PlayerLocation;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameDisplay extends JPanel implements KeyListener {

    private final Player player;
    private JPanel gamePanel;
    private JTextArea mapArea;
    private int playerX, playerY = 0;
    private Font arialTitle = new Font("arial", Font.BOLD, 40);
    private Font arialSubtext = new Font("arial", Font.PLAIN, 15);
    private Font arialSubtitle = new Font("arial", Font.PLAIN, 25);
    private Font courierMap = new Font("courier", Font.PLAIN, 10);
    private String mapPath = "static/commandCenterMap.txt";
    private String[][] mapArray;

    public GameDisplay(Player player) {
        addKeyListener(this);
        this.setFocusable(true);
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        revalidate();

        /*
        The background, player status, messages, inventory, needs to be a transparent layer
        that's overlayed on top of the playscreen which holds the map and handles player movement
         */
        //Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1024, 1024);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, 1000, 750, 5, 5); // main screen area
        g.drawRoundRect(5, 760, 200, 200, 5, 5); // player status
        g.drawRoundRect(214, 760, 590, 200, 5, 5); // messages & location
        g.drawRoundRect(814, 760, 190, 200, 5, 5); // inventory

        // prints the title portion
        g.setFont(arialTitle);
        g.drawString("Alien Invasion", 600, 70);
        g.setFont(arialSubtext);
        g.drawString("Some Text Here", 600, 150);
        // put messages somewhere in the x: 250, y 790 range

        // player status
        g.setFont(arialSubtitle);
        g.drawString("Player Status:", 25, 790);
        g.setFont(arialSubtext);
        g.drawString("HP etc", 25, 815);

        // messages placeholder
        g.setFont(arialSubtitle);
        g.drawString(player.getCurrentLocation(), 350, 790);
        g.drawString("MESSAGES", 225, 830);
        g.setFont(arialSubtext);
        g.drawString(PlayerLocation.displayCurrentLocation(player.getCurrentLocation()), 250, 860);
        g.drawString("and more here if they need to span more than one line", 250, 880);

        // inventory
        g.setFont(arialSubtitle);
        g.drawString("INVENTORY", 830, 790);

        // input field
        JTextField inputField = new JTextField();

        // map from Resources/commandCenterMap.txt
        g.setFont(arialSubtext);
        mapArray = buildMap(mapPath);

        int startX = 25;
        int startY = 50;
        // Array[y][x]
        for (int y = 0; y < mapArray.length; y++) { // go through each row
            for (int x = 0; x < mapArray[y].length; x++) {
                g.drawString(mapArray[y][x], startX, startY);
                startX += 12;
            }
            startY += 15;
            startX = 25;
        }
    }

    private String[][] buildMap(String filePath)  {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numRows = 0;
            int numCols = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                numRows++;
                numCols = Math.max(numCols, line.length());
            }
            String[][] buildMapArray = new String[numRows][numCols]; // String[y][x] coordinates
            reader.close();
            BufferedReader newReader = new BufferedReader(new FileReader(filePath));

            int y = 0;
            while ((line = newReader.readLine()) != null) { // reads line by line
                for (int x = 0; x < line.length(); x++) { // for the x position
                    buildMapArray[y][x] = String.valueOf(line.charAt(x));
                }
                for (int x = line.length(); x < numCols; x++) { // pad so all lines have the same number of chars
                    buildMapArray[y][x] = " ";
                }
                y++;
            }
            return buildMapArray;

        } catch (IOException e){
            System.out.println("gui > GameDisplay > buildMap ERROR: file not found");
            return null;
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}