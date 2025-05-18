package org.example.view.map;

import javax.swing.*;

public class BottomMap extends CellMap{

    public BottomMap(TopMap topMap){
        width = topMap.width;
        height = topMap.height;
        map = new Cell[width][height];
        for (int j = 0; j < getHeight(); j++) {
            for (int i = 0; i < getWidth(); i++) {
                map[i][j] = new Cell(
                        switch (topMap.map[i][j].type){
                            case TYPE_PASSABLE -> {
                                yield getFloor();
                            }
                            case TYPE_IMPASSABLE -> {
                                yield getWall();
                            }
                            case TYPE_IMPASSABLE_DECORATION -> {
                                yield getTable();
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + topMap.map[i][j].type);
                        },
                        topMap.map[i][j].type);
            }
        }
    }
    @Override
    protected ImageIcon getWall() {
        return new ImageIcon("src/main/resources/assets/interior/digital_wall.jpg");
    }

    @Override
    protected ImageIcon getFloor() {
        return new ImageIcon("src/main/resources/assets/interior/digital_floor_empty.jpg");
    }

    @Override
    protected ImageIcon getTable() {
        return new ImageIcon("src/main/resources/assets/interior/digital_floor_decoration.jpg");
    }

    @Override
    protected ImageIcon getChair() {
        return new ImageIcon("src/main/resources/assets/interior/digital_floor_decoration.jpg");
    }

    @Override
    protected ImageIcon getPlant() {
        return new ImageIcon("src/main/resources/assets/interior/digital_floor_decoration.jpg");
    }

    @Override
    protected ImageIcon getCat() {
        return new ImageIcon("src/main/resources/assets/interior/digital_cat.jpg");
    }
}
