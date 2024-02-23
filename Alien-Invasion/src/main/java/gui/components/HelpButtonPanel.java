package gui.components;

import gui.AbstractPanelCreator;
import models.Player;
import utils.DisplayMethodsGUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButtonPanel extends AbstractPanelCreator {
    public HelpButtonPanel(String thisLabel) {
        super(thisLabel);
        setBackground(Color.BLACK);
        setBorder(null);
        setVisible(true);
    }

    public JPanel newPanel(Player player, int x, int y, int width, int height, JPanel panel) {
        super.newPanel(player, x, y, width, height);
        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(1,1,1,1));
        setLayout(new BorderLayout(0,0));

        // The actual help button
        JButton helpButton = super.returnButton("Help", 200, 200);

        add(helpButton);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayMethodsGUI.hidePanel(panel);
            }
        });

        return this;
    }
}