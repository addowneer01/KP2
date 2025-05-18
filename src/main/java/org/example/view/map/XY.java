package org.example.view.map;

public class XY {
    int x;
    int y;
    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(XY o) {
        return o.x ==x && o.y == y;
    }
}
