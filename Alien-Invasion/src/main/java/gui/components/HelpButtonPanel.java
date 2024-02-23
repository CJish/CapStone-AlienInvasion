package gui.components;

import gui.AbstractPanelCreator;

import java.awt.*;

public class HelpButtonPanel extends AbstractPanelCreator{

    public HelpButtonPanel(String thisLabel) {
        super(thisLabel);
        setBackground(Color.BLACK);
        setBorder(null);
        setVisible(true);
    }
}