package gui.components;

import gui.AbstractPanelCreator;

import java.awt.*;

public class UserInputPanel extends AbstractPanelCreator {

    public UserInputPanel(String thisLabel) {
        super(thisLabel);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.BLACK);
    }
}