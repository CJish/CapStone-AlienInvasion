package utils;

import gameEngines.TextParser;
import models.Player;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static javax.swing.text.StyleConstants.getComponent;

public class DisplayMethodsGUI {
    public static void GUItextInput(JPanel panel, Player player, int characters) {
        // Create a panel to hold the text input
        JPanel userInputPanel = new JPanel();
        userInputPanel.setLayout(new BorderLayout());
//        userInputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add some padding

        // Create the text input field
        JTextField userInput = new JTextField();
        userInput.setColumns(characters);
        userInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY), // Add a border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Add padding inside the border
        ));

        // Customize font and size
        userInput.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add a placeholder text
        userInput.setUI(new JTextFieldHintUI("Enter your text here", Color.GRAY));

        userInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userInput.getText();
                TextParser.textParser(userText, player);
                userInput.setText("");
            }
        });

        // Add the text input field to the panel
        userInputPanel.add(userInput, BorderLayout.CENTER);

        // Add the panel to the main panel
        panel.add(userInputPanel, FlowLayout.LEFT);
    }
}

class JTextFieldHintUI extends BasicTextFieldUI implements FocusListener {

    private final String hint;
    private final Color hintColor;

    public JTextFieldHintUI(String hint, Color hintColor) {
        this.hint = hint;
        this.hintColor = hintColor;
    }

    private void repaint() {
        if (getComponent() != null) {
            getComponent().repaint();
        }
    }

    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JTextComponent component = getComponent();
        if (component.getText().length() == 0 && !component.hasFocus()) {
            g.setColor(hintColor);
            int padding = (component.getHeight() - component.getFont().getSize()) / 2;
            g.drawString(hint, 2, component.getHeight() - padding - 1);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        repaint();
    }
}