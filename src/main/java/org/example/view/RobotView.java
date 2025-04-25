package org.example.view;

import javax.swing.*;
import java.awt.*;

public class RobotView extends ImageIcon {
    public byte orientation = 2;
    private final static ImageIcon[] robot = new ImageIcon[8];
    public RobotView(){
        init();
    }
    static void init(){
        for (int i = 0;i<8;i++) robot[i] = new ImageIcon("src/main/resources/assets/robot/robot_"+i+".png");
//                new ImageIcon(new ImageIcon("src/main/resources/assets/robot/robot_"+i+".png")
//                        .getImage().getScaledInstance(128,128, Image.SCALE_DEFAULT));
    }
//    public void setOrientation(byte o){
//        orientation = o;
//    }
    public ImageIcon get(){
        return robot[orientation];
    }
}
