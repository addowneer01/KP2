package org.example.view.map;

import org.example.FileUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class TopMap extends CellMap{
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
                if (map[i][j] == '1') x = new Cell(getWall());
                else x = new Cell(getFloor());
                this.map[i][j] = x;
            }
        }

    }

    @Override
    protected ImageIcon getWall() {
        return new ImageIcon("src/main/resources/assets/interior/wall.jpg");
    }

    @Override
    protected ImageIcon getFloor() {
        return new ImageIcon("src/main/resources/assets/interior/floor.jpg");
    }
}
