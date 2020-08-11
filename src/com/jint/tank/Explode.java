package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/7/20.
 */
public class Explode extends GameObject{
    public static final int WIDTH = ResourceMgr.explods[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explods[0].getHeight();
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
//        new Audio("audio/explode.wav").loop();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explods[step++], x, y, null);
        if (step >= ResourceMgr.explods.length) {
            GameModel.getInstance().remove(this);
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
