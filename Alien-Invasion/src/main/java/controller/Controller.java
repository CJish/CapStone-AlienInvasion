package controller;

import app.AlienInvasionApp;

import javax.swing.*;


public class Controller {

    public static void main(String[] args){
//        AlienInvasionApp app = new AlienInvasionApp();
//        app.run();

        // TODO: we'll have to do some work in order to get everything running in the GUI
        // this simply pops up a new screen
        AlienInvasionApp app = new AlienInvasionApp();
        app.createAndShowGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so the process stops when screen closed
    }
}