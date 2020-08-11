package com.jint.tank.observer;

/**
 * 观察者模式（事件源->按ctrl键、观察者->TankFireHandler、事件->TankFireEvent）
 * Created by jint on 2020/8/11.
 */
public interface TankFireObserver {
    void actionFire(TankFireEvent event);
}
