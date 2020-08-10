package com.jint.tank.cor;

import com.jint.tank.GameObject;
import com.jint.tank.Tank;

/**
 * Created by jint on 2020/8/10.
 */
public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.rect.intersects(t2.rect)) {
                t1.stop();
                t2.stop();
            }
        } else {
            return;
        }
    }
}
