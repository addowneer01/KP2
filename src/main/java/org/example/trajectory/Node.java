package org.example.trajectory;

import org.example.view.map.XY;

public class Node{
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