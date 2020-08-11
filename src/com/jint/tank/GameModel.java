package com.jint.tank;

import com.jint.tank.cor.ColliderChain;
import com.jint.tank.strategy.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 门面（Facade）模式   GameModel作为Facade，负责与Frame打交道
 * 中介者（Mediator）模式  处理内部事务
 * Created by jint on 2020/8/10.
 */
public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;
    public List<GameObject> objects = new ArrayList<>();
    ColliderChain chain = new ColliderChain();
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public GameModel() {}

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private void init() {
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + 80 * i, 200, Dir.DOWN, Group.BAD));
        }
        add(new Wall(150, 150, 200,50));
        add(new Wall(550, 150, 200,50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public void add(GameObject object) {
        objects.add(object);
    }

    public void remove(GameObject object) {
        objects.remove(object);
    }

    public void paint(Graphics g) {
//        g.drawString("子弹数量：" + bullets.size(), 10, 60);
//        g.drawString("敌人数量：" + tanks.size(), 10, 80);
//        g.drawString("爆炸数量：" + explodes.size(), 10, 100);
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
