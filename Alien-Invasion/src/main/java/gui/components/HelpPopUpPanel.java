package gui.components;

import gui.AbstractPanelCreator;

import javax.swing.*;
import java.awt.*;

public class HelpPopUpPanel extends AbstractPanelCreator {

    // TODO: move this to an external file
    private String helpText = "Welcome to Alien Invasion \n\n\n\n" +
            " A hostile alien species somehow boarded your ship and killed every human on board.\n\n" +
            " \t EXCEPT YOU\n\n " +
            " The only option you can think of is to collect the Toxic Gas from the Command Center\n" +
            " remove the Vent Cover in the Vent Room, and use the gas to kill the aliens.\n" +
            " Will this kill you, too? Sure will, unless you have a Gas Mask\n\n\n\n" +
            " This is a text-based game where you type what you want your player to do.\n\n" +
            " For example, if you want to move up on the screen, you'd select the text input bar in the middle and type:\n\n\n" +
            "\t 'Move up', or 'go north' and then press the [ENTER] key.\n\n" +
            "\t You can also use arrow keys and NUMPAD (still need to select the input bar)\n\n" +
            " You can be fairly loose with your commands as we saw above, but in general you'll want to start with a verb\n\n" +
            " followed by a thing (noun).\n\n" +
            " Some actions you might want to try:\n\n\n" +
            "   go\tmove\tget\ttalk\tlook\tdrop\tquit...\n\n\n" +
            " Play around and have fun and be sure to like and comment below!" ;

    public JTextArea helpTextArea;

    public HelpPopUpPanel(String thisLabel) {
        super("");
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