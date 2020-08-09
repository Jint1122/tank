package com.jint.tank.abstractfactory;

import com.jint.tank.*;

import java.awt.*;

/**
 * Created by jint on 2020/8/9.
 */
public class RectBullet extends BaseBullet{
    private static final int SPEED = 10;

    private int x;
    private int y;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean living = true;
    private TankFrame tf;
    private Group group = Group.BAD;

    Rectangle rect = new Rectangle();

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20, 20);
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
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT ) {
            living = false;
        }
    }

    @Override
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return;
        }
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH /2 - Explode.WIDTH /2;
            int eY = tank.getY() + Tank.HEIGHT /2 - Explode.HEIGHT /2;
            tf.explodes.add(tf.gf.createExplode(eX, eY, tf));

        }
    }

    private void die() {
        this.living = false;
    }
}
