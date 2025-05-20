package org.example.trajectory;

import org.example.view.map.XY;

import java.util.HashSet;

public class Node implements Parameters{
    Node previous = null;
    public Node next = null;
    public XY pos;
    public byte nextDir;
    public Node(XY pos) {
        this.pos = pos;
    }
    public Node(Node copy){
        pos = copy.pos;
        nextDir = copy.nextDir;
    }
}