package org.example.algo;

import org.example.Config;
import org.example.trajectory.Node;
import org.example.trajectory.Road;
import org.example.view.RobotView;
import org.example.view.map.Cell;
import org.example.view.map.CellMap;
import org.example.view.map.XY;
import java.util.HashSet;
import java.util.LinkedList;

public class Greedy implements Config {
    HashSet<XY> remains = new HashSet<>();
    public Greedy(CellMap cellMap){
        Cell[][] map = cellMap.map;
        for (int i = 0;i< cellMap.getWidth();i++) {
            for (int j = 0; j < cellMap.getHeight(); j++) {
                if (map[i][j].type == TYPE_PASSABLE) remains.add(new XY(i,j));
            }
        }
    }
    public LinkedList<Byte> getNext(RobotView robotView){
        Road min = null;
        XY minXY = null;
        for (XY xy:remains){
            Road x = AStar.getShortCut(robotView.getXY(),xy);
            if (min==null||min.getSize()>x.getSize()) {
                min = x;
                minXY = xy;
            }
        }
        remains.remove(minXY);
        LinkedList<Byte> y = new LinkedList<>();
        Node node = min.getFirst();
        while (node!= null){
            y.add(node.nextDir);
            node = node.next;
        }
        return y;
    }
}
