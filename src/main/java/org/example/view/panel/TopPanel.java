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
    public final RobotView robot = new RobotView();
    public TopPanel() {
        setBackground(Color.BLACK);
        topMap = new TopMap(MAP_PATH);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int j = 0; j < topMap.getHeight(); j++) {
            for (int i = 0; i < topMap.getWidth(); i++) {
                for (ImageIcon icon : topMap.getMap()[i][j].getLayers()) {
                    if (icon != null) {
                        Image img = icon.getImage();
                        g.drawImage(img, i*SPRITE_SIZE+1*i, j*SPRITE_SIZE+1*j, SPRITE_SIZE, SPRITE_SIZE, this);
                    }
                }
            }
        }
        topMap.getMap()[5][3].addRobot(robot);
//        for (int j = 0; j < topMap.getHeight(); j++)
//            g.drawLine(0, j*SPRITE_SIZE+1*j - 1,topMap.getWidth()*(SPRITE_SIZE)+topMap.getWidth()-1,j*SPRITE_SIZE+1*j - 1);
//        for (int i = 0; i < topMap.getWidth(); i++)
//            g.drawLine( i*SPRITE_SIZE+1*i - 1,0,i*SPRITE_SIZE+1*i - 1,topMap.getHeight()*SPRITE_SIZE+topMap.getHeight()-1);
    }
    public void next(Cell[][] newMap){
        topMap.map = newMap;
        if (robot.orientation == 7) robot.orientation = 0;
        else robot.orientation++;
        repaint();
    }
}
