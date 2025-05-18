package org.example;

import org.example.mode.RateMode;
import org.example.mode.TimerMode;

public interface Config {
    int SPRITE_SIZE = 64;
    String NAME = "Robot vacuum cleaning analyzer";
    String ICON_PATH = "src/main/resources/assets/robot/robot 1024x1024.png";
    String MAP_PATH = "src/main/resources/maps/mainMap_64";
    RateMode DEFAULT_RATE_MODE = new TimerMode(100);
    //////////////////////////////////////////////////////////////
    int TYPE_PASSABLE = 0;
    int TYPE_IMPASSABLE = 1;
    int TYPE_IMPASSABLE_DECORATION = 2;
}
