package org.example.view;

import org.example.Config;
import org.example.view.mode.RateMode;
import org.example.view.panel.BottomPanel;
import org.example.view.panel.SidePanel;
import org.example.view.panel.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements Config{
    private final Image icon = new ImageIcon(ICON_PATH).getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
    public static TopPanel topPanel;
    public static BottomPanel bottomPanel;
    public static SidePanel sidePanel;
    private RateMode rateMode = DEFAULT_RATE_MODE;
    public MainFrame(String name) {
        super(name);
        init();
    }
    void init(){
        setIconImage(icon);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        topPanel = new TopPanel();
        bottomPanel = new BottomPanel();
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);
        sidePanel = new SidePanel();
        add(centerPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
            @Override
            public void componentMoved(ComponentEvent e) {
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeiconified(WindowEvent e) {
                repaint();
            }
        });
        rateMode.init();
    }

    public void setRateMode(RateMode newRateMode){
        rateMode.stop();
        rateMode = newRateMode;
        rateMode.init();
    }
    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        repaint();
    }
    @Override
    public void repaint(){
        topPanel.setPreferredSize(new Dimension(getWidth()/20*15, getHeight()/2));
        bottomPanel.setPreferredSize(new Dimension(getWidth()/20*15, getHeight()/2));
        sidePanel.setPreferredSize(new Dimension(getWidth()/20*5, getHeight()));
        super.repaint();
    }

}
