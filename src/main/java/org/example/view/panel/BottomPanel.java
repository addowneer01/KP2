package org.example.view.panel;

import org.example.Config;
import org.example.algo.AStar;
import org.example.trajectory.Node;
import org.example.trajectory.Road;
import org.example.view.RobotView;
import org.example.view.map.BottomMap;
import org.example.view.map.TopMap;
import org.example.view.map.XY;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel implements Config {
    public BottomMap bottomMap;
    public RobotView robotView;
    public static Road trace;
    private final ImageIcon emptyCell = new ImageIcon("src/main/resources/assets/interior/digital_empty.jpg");
    public BottomPanel(TopMap topMap) {
        setBackground(Color.BLACK);
        robotView = topMap.getRobotView();
        bottomMap = new BottomMap(topMap);
        trace = new Road(new XY(robotView.cX,robotView.cY),5);
    }
    Node algo = AStar.getShortCut(new XY(5,4),new XY(14,2)).getFirst();
    public void next(){
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int j = 0; j < bottomMap.getHeight(); j++) {
            for (int i = 0; i < bottomMap.getWidth(); i++) {
                if (bottomMap.map[i][j].visibility)
                    for (ImageIcon icon : bottomMap.map[i][j].getLayers()) {
                        if (icon != null) {
                            Image img = icon.getImage();
                            g.drawImage(img, i*SPRITE_SIZE+1*i, j*SPRITE_SIZE+1*j, SPRITE_SIZE, SPRITE_SIZE, this);
                        }
                    }
                else g.drawImage(emptyCell.getImage(), i*SPRITE_SIZE+1*i, j*SPRITE_SIZE+1*j, SPRITE_SIZE, SPRITE_SIZE, this);
            }
        }
        drawRoad(g,trace.getFirst(),Color.WHITE);
        drawRoad(g, algo,Color.RED);
    }
    public void drawRoad(Graphics g,int x0,int y0, int x, int y, Color color){
        Graphics2D g2 = (Graphics2D) g;
        int r = 15;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(x0*SPRITE_SIZE+x0 +SPRITE_SIZE/2,y0*SPRITE_SIZE+y0 +SPRITE_SIZE/2,
                x*SPRITE_SIZE+x +SPRITE_SIZE/2,y*SPRITE_SIZE+y +SPRITE_SIZE/2);
        g2.fillOval(x*SPRITE_SIZE+x +SPRITE_SIZE/2-r/2,y*SPRITE_SIZE+y +SPRITE_SIZE/2-r/2,r,r);
    }
    public void drawRoad(Graphics g, XY pos0, XY pos, Color color){
        drawRoad(g,pos0.x,pos0.y,pos.x,pos.y,color);
    }
    public void drawRoad(Graphics g, Node first, Color color){
        while (first.next != null){
            drawRoad(g,first.pos,first.next.pos,color);
            first = first.next;
        }
    }
}
