package com.jint.tank;

import java.awt.*;
import java.util.Random;

/**
 * Created by jint on 2020/7/20.
 */
public class Tank{
    private int x;
    private int y;
    private Dir dir;
    private boolean moving = true;
    private TankFrame tankFrame;
    private static final int SPEED = 3;
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getHeight();

    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    public Rectangle rect = new Rectangle();

    FireStrategy fireStrategy = new DefaultFireStrategy();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        String fileName;
        try {
            if (group == Group.GOOD) {
                fileName = (String) PropertyMgr.get("goodFS");
            } else {
                fileName = (String) PropertyMgr.get("badFS");
            }
            fireStrategy = (FireStrategy) Class.forName(fileName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            default:
                break;

        }
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LEFT:
                x -=  SPEED;
                break;
            case UP:
                y -=  SPEED;
                break;
            case RIGHT:
                x +=  SPEED;
                break;
            case DOWN:
                y +=  SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;

    }

    private void boundsCheck() {
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.y < 30) {
            this.y = 30;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) {
            this.x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) {
            this.y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
