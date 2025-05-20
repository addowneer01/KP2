package org.example.view.map;

public class XY{
    public int x;
    public int y;
    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(XY o) {
        return o.x ==x && o.y == y;
    }
    @Override
    public boolean equals(Object obj) {
        XY other = (XY) obj;
        return x == other.x && y == other.y; // сравнение по значениям координат
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
