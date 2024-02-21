package gui.components;

import gui.AbstractPanelCreator;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties
public class MapScreenPanel extends AbstractPanelCreator {
    public MapScreenPanel(String thisLabel) {
        super(thisLabel);
    }

    private Font mapFont = new Font("arial", Font.PLAIN, 15);
    private String mapPath = "static/commandCenterMap.txt";
    private String[][] mapArray;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        revalidate();

        this.setBackground(Color.black);
        this.setForeground(Color.lightGray);
        // map from Resources/commandCenterMap.txt
        g.setFont(mapFont);

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


}