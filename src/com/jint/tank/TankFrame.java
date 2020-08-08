package com.jint.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by jint on 2020/7/19.
 */
public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    List<Explode> explodes = new ArrayList();

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

//    Image offScreenImage = null;
//    @Override
//    public void update(Graphics g) {
//        if (offScreenImage == null) {
//            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
//        }
//        Graphics gOffScreen = offScreenImage.getGraphics();
//        Color c = gOffScreen.getColor();
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
//        g.setColor(c);
//        paint(gOffScreen);
//        g.drawImage(offScreenImage, 0, 0, null);
//    }

    @Override
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

    class MyKeyListener extends KeyAdapter {
        boolean BL = false;
        boolean BU = false;
        boolean BR = false;
        boolean BD = false;


        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!BL && !BU && !BR && !BD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (BL) {
                    myTank.setDir(Dir.LEFT);
                }
                if (BU) {
                    myTank.setDir(Dir.UP);
                }
                if (BR) {
                    myTank.setDir(Dir.RIGHT);
                }
                if (BD) {
                    myTank.setDir(Dir.DOWN);
                }
            }
        }
    }
}
