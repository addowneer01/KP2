package org.example.trajectory;

import org.example.view.map.XY;

import java.util.HashSet;

public class Road {
    Node first;
    Node last;
    private float size = 0;
    private int maxTrace;
    public final HashSet<XY> passed;
    public Road(XY pos, int trace){
        pos.c = 0;
        first = new Node(pos);
        last = first;
        size++;
        maxTrace = trace;
        passed = new HashSet<>();
        passed.add(first.pos);
    }
    public Road(Road copy){
        size = copy.size;
        maxTrace = copy.maxTrace;
        passed = copy.passed;
        Node copyNode = copy.first;
        first = new Node(copyNode);
        last = first;
        while (copyNode.next !=null) {
            add(copyNode.nextDir,copyNode.next.pos);
            copyNode = copyNode.next;
        }
    }
    public void add(byte dirToNewPos, XY newPos){
        Node p = last;
        p.nextDir = dirToNewPos;
        last = new Node(newPos);
        p.next = last;
        last.previous = p;
        passed.add(newPos);
        if (dirToNewPos%2==1&&maxTrace==0) size+=Math.sqrt(2);
        else size++;
        last.pos.c = size;
        if (maxTrace!=0&& maxTrace+1<size){
            first = first.next;
            first.previous = null;
            size = maxTrace+1;
        }
    }
    public float getSize(){
        return size;
    }
    public Node getFirst(){
        return first;
    }
    public Node getLast(){
        return last;
    }
}
