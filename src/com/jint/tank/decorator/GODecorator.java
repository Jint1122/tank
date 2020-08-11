package com.jint.tank.decorator;

import com.jint.tank.GameObject;

/**
 * 装饰者模式
 * Created by jint on 2020/8/11.
 */
public abstract class GODecorator extends GameObject {
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

}
