package controller;

import app.AlienInvasionApp;
import gui.GameDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utils.UtilFunctions.createColoredPanel;


public class Controller implements ActionListener{

    private BufferedImage alienSoldierBufferedImg = ImageIO.read(new File("static/alienSoldier.jpg"));
    private JLayeredPane layeredPane;
    private JPanel panel1;
    private JPanel panel2;
    private GameDisplay gameDisplay = new GameDisplay();
    private int windowWidth = alienSoldierBufferedImg.getWidth();
    private int windowHeight = alienSoldierBufferedImg.getHeight();
    private int centerX = windowWidth / 2;
    private int centerY = windowHeight / 2;
    private static JFrame persistentGameFrame = new JFrame();

    public Controller(JFrame jFrame) throws IOException {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(windowWidth, windowHeight);
        layeredPane = new JLayeredPane();
        jFrame.add(layeredPane);
        JButton button = new JButton("Click to play Alien Invasion");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.getContentPane().add(gameDisplay);
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
        button.setPreferredSize(new Dimension(windowWidth / 5, windowHeight / 10));
        button.setMinimumSize(new Dimension(windowWidth / 10, windowHeight / 12));
        panel1 = createColoredPanel(Color.BLACK, 0, 0, windowWidth, windowHeight);
        panel2 = createColoredPanel(Color.WHITE, centerX - 100, centerY - 100, windowWidth / 5, windowHeight / 12);
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        jFrame.setIconImage(alienSoldierBufferedImg);
        JLabel alienSoldierLabel = new JLabel(new ImageIcon(alienSoldierBufferedImg));
        panel1.add(alienSoldierLabel);
        panel2.add(button, BorderLayout.CENTER);
        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER);
    }

    public static void main(String[] args) throws IOException {
//        AlienInvasionApp app = new AlienInvasionApp();
//        app.run();

        // TODO: we'll have to do some work in order to get everything running in the GUI
        // this simply pops up a new screen
        Controller controller = new Controller(persistentGameFrame);
        persistentGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        persistentGameFrame.setLocationRelativeTo(null);
        persistentGameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}