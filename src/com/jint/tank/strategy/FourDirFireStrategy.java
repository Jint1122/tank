package com.jint.tank.strategy;

import com.jint.tank.Bullet;
import com.jint.tank.Dir;
import com.jint.tank.GameModel;
import com.jint.tank.Tank;

/**
 * Created by jint on 2020/8/9.
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH /2 - Bullet.WIDTH /2;
        int bY = t.y + Tank.HEIGHT /2 - Bullet.HEIGHT /2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            GameModel.getInstance().add(new Bullet(bX, bY, dir, t.getGroup()));
        }
    }
}
