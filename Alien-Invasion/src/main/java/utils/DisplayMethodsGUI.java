package utils;
import client.NewGame;
import gameEngines.JsonReader;
import gameEngines.TextParser;
import models.Player;

import javax.swing.*;

import gameEngines.TextParser;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayMethodsGUI {
    // this replaces our prompter. call this method under an actionlistner
// and pass it the JTextField that you want to capture the text.
    public static void GUItextInput(JPanel panel, Player player, int characters) {
        JTextField userInput = new JTextField();
        userInput.setColumns(characters);
        userInput.setBounds(0, 0, 1000, 0);

        userInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userInput.getText();
                TextParser.textParser(userText, player);
            }
        });
        panel.add(userInput, FlowLayout.LEFT);

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

    public static void currentLocationNPCs(String currentLocation, JTextArea description){
        if (JsonReader.getLocationByName(currentLocation).getCharacters() != null) {
            List<String> NPCs = JsonReader.getLocationByName(currentLocation).getCharacters();
            description.append("\nCharacters near by: \n");
            String oldText = description.getText();
            for (String characters : NPCs) {
                oldText = oldText.concat(characters);
                System.out.println(oldText);
                description.append(characters + "\n");
            }
        } else {

        }
    }
}