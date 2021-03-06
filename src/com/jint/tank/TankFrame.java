package com.jint.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jint on 2020/7/19.
 */
public class TankFrame extends Frame {
//    public GameFactory gf = new DefaultFactory();

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
        GameModel.getInstance().paint(g);
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
                    GameModel.getInstance().getMainTank().handleFireKey();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            Tank myTank = GameModel.getInstance().getMainTank();
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
