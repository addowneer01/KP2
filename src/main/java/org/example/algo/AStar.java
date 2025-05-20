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
            if (map[next.x][next.y].type == TYPE_PASSABLE&& !road.passed.contains(next.getXY())) {
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
            int n1 = Math.round(AStar.imaginaryValue(o1,f)-imaginaryValue(o2,f));
//            if (n1!=0) return n1;
//            int n2 = (int) Math.ceil(
//                    Math.sqrt(Math.pow(o1.getLast().pos.x - f.x,2)+Math.pow(o1.getLast().pos.y - f.y,2))
//                    - Math.sqrt(Math.pow(o2.getLast().pos.x - f.x,2)+Math.pow(o2.getLast().pos.y - f.y,2))
//            );
            return n1;
        }
    }
    private static float imaginaryValue(Road road,XY f){
        return Math.max(Math.abs(road.getLast().pos.x - f.x), Math.abs(Math.abs(road.getLast().pos.y - f.y)))
                + road.getSize();
    }
}
