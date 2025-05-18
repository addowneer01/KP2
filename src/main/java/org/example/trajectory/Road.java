package org.example.trajectory;

import org.example.view.map.XY;

import java.util.ArrayList;

public class Road<P> {
    Node<P> first;
    Node<P> last;
    private int size = 0;
    private int maxTrace;
    public Road(XY pos, int trace){
        first = new Node<>(pos);
        last = first;
        size++;
        maxTrace = trace+1;
    }
    public void add(byte dirToNewPos, XY newPos){
        Node<P> p = last;
        p.nextDir = dirToNewPos;
        last = new Node<>(newPos);
        p.next = last;
        last.previous = p;
        size++;
        if (maxTrace!=0&& maxTrace<size){
            first = first.next;
            first.previous = null;
            size = maxTrace;
        }
    }
    public int getSize(){
        return size;
    }
    public Node getFirst(){
        return first;
    }
}
