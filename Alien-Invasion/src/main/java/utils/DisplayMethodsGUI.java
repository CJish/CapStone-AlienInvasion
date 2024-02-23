package utils;
import gameEngines.JsonReader;
import gameEngines.TextParser;
import gui.components.CurrentLocationItemsPanel;
import gui.components.CurrentLocationNPCPanel;
import models.Player;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

public class DisplayMethodsGUI {
    // this replaces our prompter. call this method under an actionlistner
// and pass it the JTextField that you want to capture the text.
    public static void GUItextInput(JPanel panel, Player player, int characters) {
        JTextField userInput = new JTextField();
        JTextField userPrompt = new JTextField();

        userInput.setColumns(characters);
        userInput.setBounds(0, 0, 600, 0);
        userInput.setFont(new Font("Arial", Font.PLAIN, 20));
        userInput.setBackground(Color.WHITE);
        userInput.setForeground(Color.BLACK);
        userInput.setBorder(null);
        userInput.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        userPrompt.setBounds(0, 0, 400, 30);
        userPrompt.setBackground(Color.BLACK);
        userPrompt.setForeground(Color.WHITE);
        userPrompt.setFont(new Font("Arial", Font.BOLD, 20));
        userPrompt.setText("What's your command?: ");
        userPrompt.setEditable(false);
        userPrompt.setLayout(new FlowLayout(FlowLayout.LEFT, 10,1));
        userPrompt.setBorder(null);
        userInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userInput.getText();
                TextParser.textParser(userText, player);
                DisplayMethodsGUI.currentLocationItems(player.getCurrentLocation(), CurrentLocationItemsPanel.items);
                DisplayMethodsGUI.currentLocationNPCs(player.getCurrentLocation(), CurrentLocationNPCPanel.characters);
            }
        });
        panel.add(userPrompt);
        panel.add(userInput);
        panel.setBorder(new EmptyBorder(1, 80, 1, 1));

    }

    // this replaces system.out.println()
    // call this method when you need to update displayed text and pass it the display box
    // that you need it to display on, as well as the text you want to display
    public static void GUIdisplayText(JPanel panel, String wordsToWrite, int x, int y) {
        JTextArea placeToShow = new JTextArea();
        placeToShow.setText(wordsToWrite);
        placeToShow.setVisible(true);
        placeToShow.setForeground(Color.black);
        placeToShow.setEditable(false);
        panel.add(placeToShow);
    }

    // takes the place
    public static void GUIshowImage(JPanel panel, String image, int sizeX, int sizeY) {
        ImageIcon imageToShow = new ImageIcon("static/images/" + image + ".jpg");
        JLabel placeToShow = new JLabel(imageToShow);
        placeToShow.setVisible(true);
        panel.add(placeToShow);
    }

    public static void currentLocationNPCs(String currentLocation, JTextArea textArea){
        if (JsonReader.getLocationByName(currentLocation).getCharacters() != null) {
            if (textArea.getText() == null || textArea.getText().equals("")) {
                printNpcText(currentLocation, textArea);
            } else {
                textArea.setText("");
                printNpcText(currentLocation, textArea);
            }

        }
    }

    public static void currentLocationItems(String currentLocation, JTextArea textArea){
        if (JsonReader.getLocationByName(currentLocation).getItems() != null) {
            if (textArea.getText() == null) {
                printItemsText(currentLocation, textArea);
            } else {
                textArea.setText("");
                printItemsText(currentLocation, textArea);
            }
        }
    }

    private static void printItemsText(String currentLocation, JTextArea textArea) {
        List<String> NPCs = JsonReader.getLocationByName(currentLocation).getItems();
        for (String item : NPCs) {
            textArea.append(item + "\n");
        }
    }
    private static void printNpcText(String currentLocation, JTextArea textArea) {
        List<String> NPCs = JsonReader.getLocationByName(currentLocation).getCharacters();
        for (String characters : NPCs) {
            textArea.append(characters + "\n");
        }
    }

    public static void hidePanel(JPanel panel) {
        if (panel.isVisible()) {
            panel.setVisible(false);
        } else {
            panel.setVisible(true);
        }
    }

    public static void keyPressedHandler(KeyEvent k, Player player) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_NUMPAD4:
                UtilFunctions.movePosition("west", player);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_NUMPAD6:
                UtilFunctions.movePosition("east", player);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_NUMPAD8:
                UtilFunctions.movePosition("north", player);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_NUMPAD2:
                UtilFunctions.movePosition("south", player);
                break;
        }
    }
}