package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/8/10.
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

}
