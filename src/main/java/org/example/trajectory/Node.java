package org.example.trajectory;

import org.example.view.map.XY;

public class Node{
    Node previous;
    Node next;
    XY pos;
    byte nextDir;
}