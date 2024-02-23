package gui.components;

import gui.AbstractPanelCreator;

import javax.swing.*;
import java.awt.*;

public class HelpPopUpPanel extends AbstractPanelCreator {

    // TODO: move this to an external file
    private String helpText = "\tWelcome to Alien Invasion \n\n\n\n" +
            "  This is (currently) a text-based game\n\n" +
            "where you will use loose text commands to navigate yourself through the story that plays out on the screen.\n\n\n" +
            "For example, if you want to move up on the screen, you'd select the text input bar in the middle and type:\n\n\n" +
            "'Move up', or 'go north' and then press the [ENTER] key.\n\n\n" +
            "You can be fairly loose with your commands as we saw above, but in general you'll want to use an action word (verb)\n\n" +
            "followed by a thing (noun).\n\n" +
            "Some actions you might want to try:\n\n\n" +
            "\tgo\tmove\tget\ttalk\tlook\tdrop\tquit\t...\n\n\n" +
            "Some of these you can use on their own, some need the noun as well.\n\n\n" +
            "Play around and have fun and be sure to like and comment below!\n\n\n" ;

    public JTextArea helpTextArea;

    public HelpPopUpPanel(String thisLabel) {
        super("Help");
        helpTextArea = new JTextArea(helpText, 20, 50);
        helpTextArea.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        helpTextArea.setBorder(BorderFactory.createEtchedBorder(Color.CYAN,Color.BLUE));
        helpTextArea.setBackground(Color.BLACK);
        helpTextArea.setForeground(new Color(192, 192, 192));
        helpTextArea.setVisible(true);
        add(helpTextArea);
        this.setVisible(true);
    }

    private void setHelpVisible (JPanel jPanel) {
        if (jPanel.isVisible()) {
            jPanel.setVisible(false);
            helpTextArea.setVisible(false);
        } else {
            jPanel.setVisible(true);
            helpTextArea.setVisible(true);
        }
    }

}