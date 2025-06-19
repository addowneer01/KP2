package org.example.algo;

import org.example.Config;
import org.example.trajectory.Road;
import org.example.view.MainFrame;
import org.example.view.map.*;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar implements Config {
    private XY last;
    private Cell[][] map = MainFrame.topPanel.topMap.map;
    private final PriorityQueue<Road> queue;
    private AStar(XY b){
        last = b;
        queue = new PriorityQueue<>(new RoadComparator(last));
    }
    public static Road getShortCut(XY a,XY b){
        AStar algo = new AStar(b);
        algo.newScroll(new Road(a,0));
        Road x;
        while (!algo.queue.isEmpty()){
            x = algo.queue.poll();
            if (!x.getLast().pos.equals(b)) algo.newScroll(x);
            else {

                return x;
            }
        }
        return null;
    }
    protected void newScroll(Road road){
        for (byte i = 0;i<8;i++){
            NextMove next = NextMove.get(road.getLast().pos,i);
            XY n = next.getXY();
            float q;
            if (i%2==1)  q= (float) Math.sqrt(2);
            else q = 1;
            n.c = q + road.getSize();
            if (map[n.x][n.y].type == TYPE_PASSABLE&& !road.passed.contains(n)) {
                Road newRoad = new Road(road);
                newRoad.add(i,next.getXY());
                queue.add(newRoad);
            }
        }
    }
    private static class RoadComparator implements Comparator<Road>{
        RoadComparator(XY last){
            f = last;
        }
        private final XY f;
        @Override
        public int compare(Road o1, Road o2) {
            float c1 = AStar.imaginaryValue(o1,f);
            float c2 = AStar.imaginaryValue(o2,f);
            if (c1-c2>0) return 1;
            else if (c1-c2<0) return -1;
            else return 0;
        }
    }
    private static float imaginaryValue(Road road,XY f){
        int x = Math.abs(road.getLast().pos.x - f.x);
        int y = Math.abs(road.getLast().pos.y - f.y);
        return (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2))+ road.getSize();
//        return (Math.min(x,y)*(float)Math.sqrt(2)+ Math.abs(x-y) + road.getSize());
    }
}
