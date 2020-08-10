package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/7/20.
 */
public class Explode{
    private int x;
    private int y;
    private GameModel gm;
    public static final int WIDTH = ResourceMgr.explods[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explods[0].getHeight();
    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
//        new Audio("audio/explode.wav").loop();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explods[step++], x, y, null);
        if (step >= ResourceMgr.explods.length) {
            gm.explodes.remove(this);
        }
    }

}
