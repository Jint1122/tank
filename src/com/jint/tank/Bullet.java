package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/7/20.
 */
public class Bullet {
    private static final int SPEED = 10;

    private int x;
    private int y;
    private int width = 30, height = 30;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(c);
        move();
    }

    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT ) {
            live = false;
        }
    }
}
