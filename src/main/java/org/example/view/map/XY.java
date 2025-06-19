package org.example.view.map;

public class XY{
    public int x;
    public int y;
    public float c;
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
        boolean f = x == other.x && y == other.y;
//        if (f) return other.c<c;
        return f;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
