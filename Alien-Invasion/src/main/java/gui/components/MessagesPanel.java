package gui.components;

import gui.AbstractPanelCreator;

import java.awt.*;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties

public class MessagesPanel extends AbstractPanelCreator {


    //TODO: add message specific text here
    // like we'll have to take the message and chop it up so that it fits
    // within the alloted frame

    public MessagesPanel(String thisLabel) {
        super(thisLabel);
    }

    @Override // this is just for messing around
    public void setBackground(Color bg) {
        super.setBackground(Color.BLACK);
    }

}