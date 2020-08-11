package com.jint.tank.strategy;

import com.jint.tank.Bullet;
import com.jint.tank.GameModel;
import com.jint.tank.Tank;
import com.jint.tank.decorator.RectDecorator;
import com.jint.tank.decorator.TailDecorator;

/**
 * Created by jint on 2020/8/9.
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH /2 - Bullet.WIDTH /2;
        int bY = t.y + Tank.HEIGHT /2 - Bullet.HEIGHT /2;
        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX, bY, t.getDir(), t.getGroup()))));
    }
}
