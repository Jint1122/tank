package com.jint.tank.cor;

import com.jint.tank.Bullet;
import com.jint.tank.GameObject;
import com.jint.tank.strategy.Wall;

/**
 * Created by jint on 2020/8/10.
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b1 = (Bullet) o1;
            Wall w1 = (Wall) o2;
            if (b1.rect.intersects(w1.rect)) {
                b1.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;
    }
}
