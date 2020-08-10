package com.jint.tank.cor;

import com.jint.tank.GameObject;

/**
 * Created by jint on 2020/8/10.
 */
public interface Collider {
    void collide(GameObject o1, GameObject o2);
}
