package org.example.view.map;

import org.example.Config;

import javax.swing.*;

public abstract class CellMap implements Config {
    public Cell[][] map;
    protected int width = -1;
    protected int height = -1;
    protected abstract ImageIcon getWall();
    protected abstract ImageIcon getFloor();
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    protected abstract ImageIcon getTable();
    protected abstract ImageIcon getChair();
    protected abstract ImageIcon getPlant();
    protected abstract ImageIcon getCat();
}
