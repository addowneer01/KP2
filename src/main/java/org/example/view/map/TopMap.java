package org.example.view.map;

import org.example.FileUtils;
import org.example.view.RobotView;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class TopMap extends CellMap{
    private RobotView robotView;
    public TopMap(String mapPath){
        List<String> lines = null;
        try {
            lines = FileUtils.readFile(mapPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        if (!validate(lines)) {
//            throw new RuntimeException("Map is not valid");
//        }
        createMap(lines);
    }
    private void createMap(List<String> lines) {
        width = lines.get(0).length();
        height = lines.size();
        char[][] map = new char[lines.get(0).length()][lines.size()];
        this.map = new Cell[lines.get(0).length()][lines.size()];
        int rowNumber = 0;
        for (int j = 0;j< lines.size();j++) {
            char[] x = lines.get(j).toCharArray();
            for (int i= 0;i<x.length;i++){
                map[i][j] = x[i];
            }
        }
        for (int i = 0;i< width;i++){
            for (int j = 0;j< height;j++){
                Cell x;
                if (map[i][j] == '1') x = new Cell(getWall(),TYPE_IMPASSABLE);
                else x = new Cell(getFloor(),TYPE_PASSABLE);
                if (map[i][j] == 'T') x.addDecoration(getTable());
                else if (map[i][j] == 'P') x.addDecoration(getPlant());
                else if (map[i][j] == 'C') x.addDecoration(getChair());
                else if (map[i][j] == 'R') {
                    robotView = new RobotView(i,j,this);
                }
                this.map[i][j] = x;
            }
        }

    }
    public RobotView getRobotView(){
        return robotView;
    }

    @Override
    protected ImageIcon getWall() {
        return new ImageIcon("src/main/resources/assets/interior/wall.jpg");
    }

    @Override
    protected ImageIcon getFloor() {
        return new ImageIcon("src/main/resources/assets/interior/floor.jpg");
    }

    @Override
    protected ImageIcon getTable() {
        return new ImageIcon("src/main/resources/assets/decoration/decoration_table.png");
    }

    @Override
    protected ImageIcon getChair() {
        return new ImageIcon("src/main/resources/assets/decoration/decoration_chair.png");
    }

    @Override
    protected ImageIcon getPlant() {
        return new ImageIcon("src/main/resources/assets/decoration/decoration_plant.png");
    }

    @Override
    protected ImageIcon getCat() {
        return null;
    }
}
