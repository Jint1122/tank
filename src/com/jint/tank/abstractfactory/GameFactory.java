package com.jint.tank.abstractfactory;

import com.jint.tank.Dir;
import com.jint.tank.Group;
import com.jint.tank.TankFrame;

/**
 * 抽象工厂模式（DefaultFactory、RectFactory）
 * Created by jint on 2020/8/9.
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}

