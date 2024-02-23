package gui.components;

import gui.AbstractPanelCreator;
import models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HelpButtonPanel extends AbstractPanelCreator{

    JPanel panel;

    public HelpButtonPanel(String thisLabel) {
        super(thisLabel);
        setBackground(Color.BLACK);
        setBorder(null);
        setVisible(true);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        panel = super.newPanel(player, x, y, width, height);
        panel.setBackground(Color.BLACK);
        panel.setBorder(new EmptyBorder(1,1,1,1));
        panel.setLayout(new BorderLayout(0,0));

        return panel;
    }
}