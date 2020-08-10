package com.jint.tank.cor;

import com.jint.tank.GameObject;

/**
 * 中介者（Mediator）模式 中介者处理碰撞类型
 * Created by jint on 2020/8/10.
 */
public interface Collider {
    void collide(GameObject o1, GameObject o2);
}
