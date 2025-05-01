package org.example.view.mode;

import org.example.view.MainFrame;
import org.example.view.RobotView;
import org.example.view.map.Cell;
import org.example.view.panel.TopPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DebugMode implements RateMode{
    private MainFrame mainFrame;
    public DebugMode(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    @Override
    public void init() {
        TopPanel topPanel = MainFrame.topPanel;
        RobotView robot = topPanel.robot;
        JRootPane rootPane = mainFrame.getRootPane();
        InputMap im = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = rootPane.getActionMap();
        im.put(KeyStroke.getKeyStroke("W"), "W");
        im.put(KeyStroke.getKeyStroke("S"), "S");
        im.put(KeyStroke.getKeyStroke("Q"), "Q");
        im.put(KeyStroke.getKeyStroke("E"), "E");
        im.put(KeyStroke.getKeyStroke("A"), "A");
        im.put(KeyStroke.getKeyStroke("D"), "D");
        im.put(KeyStroke.getKeyStroke("Z"), "Z");
        im.put(KeyStroke.getKeyStroke("X"), "X");
        am.put("Q", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 1);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("W", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 2);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("E", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 3);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("A", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 0);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("S", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 6);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("D", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 4);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("Z", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 7);
                if (x!=null) topPanel.next(x);
            }
        });
        am.put("X", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell[][] x = robot.move((byte) 5);
                if (x!=null) topPanel.next(x);
            }
        });
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }
}
