package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/7/20.
 */
public class Explode extends GameObject{
    private int x;
    private int y;
    public static final int WIDTH = ResourceMgr.explods[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explods[0].getHeight();
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explods[step++], x, y, null);
        if (step >= ResourceMgr.explods.length) {
            GameModel.getInstance().remove(this);
        }
    }

}
