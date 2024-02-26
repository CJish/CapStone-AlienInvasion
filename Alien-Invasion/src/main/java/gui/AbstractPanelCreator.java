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

package gui;

import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class AbstractPanelCreator extends JPanel implements KeyListener {
    private final String jLabelString;// = "Messages";
    private Player player;
    public AbstractPanelCreator(String thisLabel) {
        this.jLabelString = thisLabel;
    }

    public void customizePanel(int x, int y, int width, int height) {
        new FlowLayout(FlowLayout.CENTER);
        setBounds(x, y, width, height);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.DARK_GRAY);
    }

    // you'll have to @Override if you want to change these
    public JLabel addPanelTitleLabel() {
        JLabel thisLabel = new JLabel(getjLabelString());
        thisLabel.setFont(new Font("Arial", Font.BOLD, 20));
        thisLabel.setForeground(Color.WHITE);
        return thisLabel;
    }

    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        this.player = player;
        this.customizePanel(x, y, width, height);
        this.add(addPanelTitleLabel());
        this.repaint();
        return this;
    }

    public JButton returnButton(String buttonName, int width, int height) {
        JButton helpButton = new JButton(buttonName);
        helpButton.setPreferredSize(new Dimension(width, height));
        helpButton.setBorder(new EmptyBorder(1,1,1,1));
        return helpButton;
    }

    public String getjLabelString() {
        return jLabelString;
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}