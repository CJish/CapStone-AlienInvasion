package gui;

import gui.components.MapScreenPanel;
import models.Player;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;

public abstract class AbstractPanelCreator extends JPanel {

    private String jLabelString;// = "Messages";

    public AbstractPanelCreator(String thisLabel) {
        this.jLabelString = thisLabel;

    }

    /*
    Sets a common base for the panels that will be displayed as part of the GameDisplay
    Also allows for each panel to access the player object which controls
    most of the logic used in this game

    To modify one of the subclasses:
            @Override
            public void setBackground(Color bg) {
            super.setBackground(Color.BLACK);
            }
     You can either create a bg variable and pass it to setBackground(bg)
     or you can explicitly set it setBackground(Color.BLACK)
     */

    private void customizePanel(int x, int y, int width, int height) {
        new FlowLayout(FlowLayout.CENTER);
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.DARK_GRAY);
    }

    // you'll have to @Override if you want to change these
    private JLabel addPanelTitleLabel(String labelString) {
        JLabel thisLabel = new JLabel(jLabelString);
        thisLabel.setFont(new Font("Arial", Font.BOLD, 20));
        thisLabel.setForeground(Color.WHITE);
        return thisLabel;
    }

    public JPanel newPanel(Player player, int x, int y, int width, int height) {
//        this.player = player;
        this.customizePanel(x, y, width, height);
        this.add(addPanelTitleLabel(jLabelString));
        this.repaint();
        return this;
    }
}