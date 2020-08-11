package com.jint.tank.strategy;

import com.jint.tank.GameObject;

import java.awt.*;

/**
 * Created by jint on 2020/8/11.
 */
public class Wall extends GameObject {
    private int w,h;

    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
}
