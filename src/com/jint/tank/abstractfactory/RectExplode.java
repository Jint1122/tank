package com.jint.tank.abstractfactory;

import com.jint.tank.ResourceMgr;
import com.jint.tank.TankFrame;

import java.awt.*;

/**
 * Created by jint on 2020/8/9.
 */
public class RectExplode extends BaseExplode {
    private int x;
    private int y;
    private TankFrame tankFrame;
    public static final int WIDTH = ResourceMgr.explods[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explods[0].getHeight();
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
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
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 8) {
            tankFrame.explodes.remove(this);
        }
        g.setColor(c);
    }
}
