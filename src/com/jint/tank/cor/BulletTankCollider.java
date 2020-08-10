package com.jint.tank.cor;

import com.jint.tank.Bullet;
import com.jint.tank.GameObject;
import com.jint.tank.Tank;

/**
 * Created by jint on 2020/8/10.
 */
public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            ((Bullet) o1).collideWith((Tank) o2);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        } else {
            return;
        }
    }
}
