package com.jint.tank.abstractfactory;

import com.jint.tank.Tank;

import java.awt.*;

/**
 * Created by jint on 2020/8/9.
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
