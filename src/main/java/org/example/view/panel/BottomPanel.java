package org.example.view.panel;

import org.example.Config;
import org.example.trajectory.Road;
import org.example.view.map.BottomMap;
import org.example.view.map.TopMap;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel implements Config {
    public BottomMap bottomMap;
    private final ImageIcon emptyCell = new ImageIcon("src/main/resources/assets/interior/digital_empty.jpg");
    public BottomPanel(TopMap topMap) {
        setBackground(Color.BLACK);
        bottomMap = new BottomMap(topMap);
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
        drawRoad(g,3,3,4,3);
    }
    public void drawRoad(Graphics g,int x0,int y0, int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        int r = 15;
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(x0*SPRITE_SIZE+x0 +SPRITE_SIZE/2,y0*SPRITE_SIZE+y0 +SPRITE_SIZE/2,
                x*SPRITE_SIZE+x +SPRITE_SIZE/2,y*SPRITE_SIZE+y +SPRITE_SIZE/2);
        g2.fillOval(x*SPRITE_SIZE+x +SPRITE_SIZE/2-r/2,y*SPRITE_SIZE+y +SPRITE_SIZE/2-r/2,r,r);
    }
    public void drawRoad(Graphics g, Road road){

    }
}
