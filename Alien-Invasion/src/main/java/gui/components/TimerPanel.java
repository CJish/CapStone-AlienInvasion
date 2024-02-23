package gui.components;

import gui.AbstractPanelCreator;
import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPanel extends AbstractPanelCreator {

    private int secondsRemaining = 400; // set to whatever you want the time limit to be

    public TimerPanel(String thisLabel) {
        super(thisLabel);
    }

    private String getTimeString() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public JPanel newPanel(Player player, int x, int y, int width, int height) {
        super.newPanel(player, x, y, width, height);
        JPanel thisPanel = this;
        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(1,1,1,1));
        setLayout(new BorderLayout(0,0));
        JLabel timerLabel = new JLabel(getTimeString());
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setForeground(Color.white);
        add(timerLabel, BorderLayout.CENTER);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (secondsRemaining > 0) {
                    if (secondsRemaining < 300) {
                        int translucency = 100 - (secondsRemaining / 3);
                        thisPanel.setBackground(new Color(244, 37, 11, translucency));
                        if (secondsRemaining < 100) {
                            int fontSize = 18 + (secondsRemaining / 4);
                            thisPanel.setFont(new Font("Arial", Font.BOLD, fontSize));
                        }
                    }
                    secondsRemaining--;
                    SwingUtilities.invokeLater(() -> timerLabel.setText(getTimeString()));
                }else {
                    timer.cancel();
                    SwingUtilities.invokeLater(() -> {
                        timerLabel.setText("Time's up!");
                        JOptionPane.showMessageDialog(timerLabel, "Time's up!");
                    });
                }
            }
        }, 0, 1000); // period = time in milliseconds between ticks

        setVisible(true);

        return this;
    }

    @Override
    public void customizePanel(int x, int y, int width, int height) {
        super.customizePanel(x, y, width, height);
    }

    @Override
    public JLabel addPanelTitleLabel() {
        return super.addPanelTitleLabel();
    }
}