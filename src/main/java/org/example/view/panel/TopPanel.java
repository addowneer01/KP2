package org.example.view.panel;

import org.example.Config;
import org.example.view.RobotView;
import org.example.view.map.Cell;
import org.example.view.map.CellMap;
import org.example.view.map.TopMap;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel implements Config {
    public TopMap topMap;
    public final RobotView robot;
    public TopPanel() {
        setBackground(Color.BLACK);
        topMap = new TopMap(MAP_PATH);
        robot= topMap.getRobotView();
        topMap.map[robot.cX][robot.cY].addRobot(robot);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int j = 0; j < topMap.getHeight(); j++) {
            for (int i = 0; i < topMap.getWidth(); i++) {
                for (ImageIcon icon : topMap.map[i][j].getLayers()) {
                    if (icon != null) {
                        Image img = icon.getImage();
                        g.drawImage(img, i*SPRITE_SIZE+1*i, j*SPRITE_SIZE+1*j, SPRITE_SIZE, SPRITE_SIZE, this);
                    }
                }
            }
        }
    }
    public void next(Cell[][] newMap){
        topMap.map = newMap;
        repaint();
    }
}
