package org.example.view;

import org.example.Config;
import org.example.view.map.Cell;
import org.example.view.map.CellMap;

import javax.swing.*;

public class RobotView extends ImageIcon implements Config {
    public byte orientation = 2;
    public int cX;
    public int cY;
    private CellMap cellMap;
    private final static ImageIcon[] robot = new ImageIcon[8];
    public RobotView(int x, int y, CellMap map){
        cX= x;
        cY= y;
        this.cellMap = map;
        init();
    }
    public Cell[][] move(byte direction){
        Cell[][] newMap = cellMap.map;
        int newX;
        int newY;
        switch (direction){
            case 0 -> {
                newX = cX-1;
                newY = cY;
            }
            case 1 -> {
                newX = cX-1;
                newY = cY-1;
            }
            case 2 -> {
                newX = cX;
                newY = cY-1;
            }
            case 3 -> {
                newX = cX+1;
                newY = cY-1;
            }
            case 4 -> {
                newX = cX+1;
                newY = cY;
            }
            case 5 -> {
                newX = cX+1;
                newY = cY+1;
            }
            case 6 -> {
                newX = cX;
                newY = cY+1;
            }
            case 7 -> {
                newX = cX-1;
                newY = cY+1;
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
        Cell x = newMap[newX][newY];
        if (x.type != TYPE_PASSABLE) return null;
        orientation = direction;
        newMap[cX][cY].clearRobot();
        x.addRobot(this);
        cX = newX;
        cY = newY;
        return newMap;
    }
    static void init(){
        for (int i = 0;i<8;i++) robot[i] = new ImageIcon("src/main/resources/assets/robot/robot_"+i+".png");
    }
    public ImageIcon get(){
        return robot[orientation];
    }
}
