package org.example.trajectory;

import org.example.view.map.XY;

public class Node<P>{
    Node<P> previous = null;
    public Node<P> next = null;
    public XY pos;
    public byte nextDir;
    P p;
    public Node(XY pos){
        this.pos = pos;
    }
}