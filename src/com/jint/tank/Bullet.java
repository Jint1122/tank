package com.jint.tank;

import java.awt.*;

/**
 * Created by jint on 2020/7/20.
 */
public class Bullet extends GameObject{
    private static final int SPEED = 10;

    private int x;
    private int y;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean living = true;
    private GameModel gm;
    private Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.add(this);
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

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            gm.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
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

        if (x < 0 || y < 0 || x > GameModel.GAME_WIDTH || y > GameModel.GAME_HEIGHT ) {
            living = false;
        }
    }

    public boolean collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return false;
        }
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH /2 - Explode.WIDTH /2;
            int eY = tank.getY() + Tank.HEIGHT /2 - Explode.HEIGHT /2;
            gm.add(new Explode(eX, eY, gm));
            return true;
        }
        return false;
    }

    public void die() {
        this.living = false;
    }
}
