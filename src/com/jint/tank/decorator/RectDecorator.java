package com.jint.tank.decorator;

import com.jint.tank.GameObject;

import java.awt.*;

/**
 * Created by jint on 2020/8/11.
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x, super.go.y, getWidth(), getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
