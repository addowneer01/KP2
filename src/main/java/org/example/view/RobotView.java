package org.example.view;

import org.example.Config;
import org.example.view.map.Cell;
import org.example.view.map.CellMap;
import org.example.view.map.NextMove;

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
        NextMove nextMove = NextMove.get(cX,cY,direction);
        Cell x = newMap[nextMove.x][nextMove.y];
        if (x.type != TYPE_PASSABLE) return null;
        orientation = direction;
        newMap[cX][cY].clearRobot();
        x.addRobot(this);
        cX = nextMove.x;
        cY = nextMove.y;
        return newMap;
    }
    static void init(){
        for (int i = 0;i<8;i++) robot[i] = new ImageIcon("src/main/resources/assets/robot/robot_"+i+".png");
    }
    public boolean clear(int c){
        return true;
    }
    public ImageIcon get(){
        return robot[orientation];
    }
}
