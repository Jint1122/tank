package com.jint.tank.cor;

import com.jint.tank.*;

/**
 * Created by jint on 2020/8/10.
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b1 = (Bullet) o1;
            Tank t1 = (Tank) o2;
            if (collideWith(b1, t1)) {
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;
    }

    public boolean collideWith(Bullet b1, Tank tank) {
        if (b1.getGroup() == tank.getGroup()) {
            return false;
        }
        if (b1.rect.intersects(tank.rect)) {
            tank.die();
            b1.die();
            int eX = tank.getX() + Tank.WIDTH /2 - Explode.WIDTH /2;
            int eY = tank.getY() + Tank.HEIGHT /2 - Explode.HEIGHT /2;
            GameModel.getInstance().add(new Explode(eX, eY));
            return true;
        }
        return false;
    }
}
