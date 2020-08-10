package com.jint.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 门面（Facade）模式   GameModel作为Facade，负责与Frame打交道、同时处理内部事务
 * Created by jint on 2020/8/10.
 */
public class GameModel {
    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);
    public List<Bullet> bullets = new ArrayList<>();
    public List<Tank> tanks = new ArrayList<>();
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    public List<Explode> explodes = new ArrayList();

    public GameModel() {
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + 80 * i, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        g.drawString("子弹数量：" + bullets.size(), 10, 60);
        g.drawString("敌人数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸数量：" + explodes.size(), 10, 100);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
