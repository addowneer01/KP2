package org.example.view.map;

import org.example.Config;
import org.example.view.RobotView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cell extends JPanel implements Config {
    private final ImageIcon[] layers = new ImageIcon[3];
    public int type;

    public Cell(ImageIcon rootImage, int type) {
        setOpaque(false);
        layers[0] = rootImage;
        this.type = type;
    }
    public void setRoot(ImageIcon imageIcon){
        layers[0] = imageIcon;
        repaint();
    }
    public void addRobot(RobotView robotView){
        layers[2] = robotView.get();
        repaint();
    }
    public void clearRobot(){
        layers[2] = null;
        repaint();
    }
    public void addDecoration(ImageIcon imageIcon){
        layers[2] = imageIcon;
        type = TYPE_IMPASSABLE_DECORATION;
    }
    public void addTrash(ImageIcon imageIcon){
        layers[1] = imageIcon;
        repaint();
    }
    public void clearTrash(){
        layers[1] = null;
        repaint();
    }
    public ImageIcon[] getLayers(){
        return layers;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SPRITE_SIZE, SPRITE_SIZE);
    }
}
