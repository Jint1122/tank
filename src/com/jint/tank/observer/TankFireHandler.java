package com.jint.tank.observer;

import com.jint.tank.Tank;

/**
 * Created by jint on 2020/8/11.
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionFire(TankFireEvent event) {
        Tank t = event.getSource();
        t.fire();
    }
}
