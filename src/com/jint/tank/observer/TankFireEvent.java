package com.jint.tank.observer;

import com.jint.tank.Tank;

/**
 * Created by jint on 2020/8/11.
 */
public class TankFireEvent {
    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource() {
        return tank;
    }
}
