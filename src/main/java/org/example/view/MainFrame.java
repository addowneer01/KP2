package org.example.view;

import org.example.Config;
import org.example.view.panel.BottomPanel;
import org.example.view.panel.SidePanel;
import org.example.view.panel.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements Config, ActionListener {
    Image icon = new ImageIcon(ICON_PATH).getImage().getScaledInstance(64,64,Image.SCALE_DEFAULT);
    TopPanel topPanel;
    BottomPanel bottomPanel;
    SidePanel sidePanel;
    public MainFrame(String name) {
        super(name);
        init();
    }
    void init(){
        Timer timer = new Timer(GAME_FRAMES_PER_SECOND,this);
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
        timer.start();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        topPanel.next(topPanel.topMap.map);
    }
}
