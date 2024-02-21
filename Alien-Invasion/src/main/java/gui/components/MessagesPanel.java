package gui.components;

import gui.AbstractPanelCreator;

import java.awt.*;

// see the AbstractPanelCreator class for instructions
// on how to modify this class's properties

public class MessagesPanel extends AbstractPanelCreator {

    String messageLabelString = "Messages";

    //TODO: add message specific text here
    // like we'll have to take the message and chop it up so that it fits
    // within the alloted frame

    @Override // this is just for messing around
    public void setBackground(Color bg) {
        super.setBackground(Color.BLACK);
    }

    @Override // I F*d something up here, can't remember how to use a setter - CJ
    public void setjLabelString(String jLabelString) {
        this.setjLabelString(messageLabelString);
    }
}