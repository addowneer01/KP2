package org.example;

import org.example.view.MainFrame;
import org.example.mode.DebugMode;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame(Config.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setRateMode(new DebugMode(frame));
    }
}