package gui.components;

import app.AlienInvasionApp;
import gui.AbstractPanelCreator;
import models.Player;
import utils.UtilFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties
public class MapScreenPanel extends AbstractPanelCreator {

    Player player;
    UtilFunctions utilFunctions;

    // TODO: update all fonts together; the static font is to the player's starting location is dynamically set
    private Font mapFont = new Font("arial", Font.PLAIN, 15);
    private Font playerFont = new Font("arial", Font.BOLD, 15);
    private String mapPath = "static/commandCenterMap.txt";
    private String[][] mapArray;
    private String[][] twoDPlayerLoc;

    public MapScreenPanel (String thisLabel, Player player) {
        super(thisLabel);
        this.player = player;
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        revalidate();


        this.setBackground(Color.black);
        this.setForeground(Color.lightGray);
        // map from Resources/commandCenterMap.txt
        g.setFont(mapFont);
        g.setColor(Color.white);
        int fontsize = g.getFont().getSize();

        //
        mapArray = buildMap(mapPath);
        int playerX = player.getX();
        int playerY = player.getY();
        mapArray[playerY][playerX] = "@";

        int startX = 10; // because the map prints up and left of the current pixel
        int startY = 25; // because the map prints up and left of the current pixel
        // Array[y][x]
        for (int y = 0; y < mapArray.length; y++) { // go through each row
            for (int x = 0; x < mapArray[y].length; x++) { // go through each char in the row
                if (mapArray[y][x] == "@") { // check if current loc == player's loc
                    g.setColor(Color.CYAN);
                    g.setFont(playerFont);
//                    mapArray[y][x] = "@";
                    g.drawString(mapArray[y][x], startX, startY); // print player if yes
                    g.setFont(mapFont);
                    g.setColor(Color.white);
                } else {
                    g.drawString(mapArray[y][x], startX, startY); // print next char if no
                }
                startX += fontsize;
            }

            startY += fontsize;
            startX = fontsize;
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
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_NUMPAD8: utilFunctions.movePosition("up", player); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_NUMPAD2: utilFunctions.movePosition("down", player); break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4: utilFunctions.movePosition("west", player); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6: utilFunctions.movePosition("east", player); break;
        }
    }

}