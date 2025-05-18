package org.example.view.map;

public class NextMove {
    public int x;
    public int y;
    private NextMove(int nx, int ny){
        x = nx;
        y = ny;
    }
    public static NextMove getNextMove(int cX, int cY, int direction){
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
        return new NextMove(newX,newY);
    }
}
