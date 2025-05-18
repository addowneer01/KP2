package org.example.mode;

import org.example.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimerMode implements RateMode, ActionListener {
    private Timer timer;
    public TimerMode(int refreshRate){
        timer = new Timer(refreshRate, this);
    }
    @Override
    public void init() {
        timer.start();
    }

    @Override
    public void loop() {
        MainFrame.topPanel.next(MainFrame.topPanel.topMap.map);
    }

    @Override
    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loop();
    }
}
