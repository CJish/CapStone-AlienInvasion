package gui.components;

import gui.AbstractPanelCreator;

import java.awt.*;

public class UserInputPanel extends AbstractPanelCreator {

    public UserInputPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.WHITE);
    }
}