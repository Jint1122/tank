package com.jint.tank.cor;

import com.jint.tank.GameObject;
import com.jint.tank.Tank;
import com.jint.tank.strategy.Wall;

/**
 * Created by jint on 2020/8/10.
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t1 = (Tank) o1;
            Wall w1 = (Wall) o2;
            if (t1.rect.intersects(w1.rect)) {
                t1.back();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            collide(o2, o1);
        }
        return true;
    }
}
