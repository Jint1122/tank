package com.jint.tank;

/**
 * Created by jint on 2020/7/19.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + 80 * i, 200, Dir.DOWN, tf));
        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
