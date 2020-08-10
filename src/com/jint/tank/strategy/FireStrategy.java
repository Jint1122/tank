package com.jint.tank.strategy;

import com.jint.tank.Tank;

/**
 * 策略模式、添加开火策略（默认单方向发射、四方发射）
 * Created by jint on 2020/8/9.
 */
public interface FireStrategy {
    void fire(Tank t);
}
