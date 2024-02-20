package controller;

import app.AlienInvasionApp;
import gui.GameDisplay;
import models.Player;

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
    public static void main(String[] args) throws IOException {
        AlienInvasionApp game = new AlienInvasionApp();
        try {
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}