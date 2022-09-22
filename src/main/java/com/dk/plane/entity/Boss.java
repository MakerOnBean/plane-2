package com.dk.plane.entity;

import com.dk.plane.service.impl.GameServiceImpl;
import com.dk.plane.utils.GameUtils;

import javax.swing.*;
import java.awt.*;

public class Boss extends Base {

    int life = 10;

    public Boss(Image image, int x, int y, int width, int height, int speed) {
        super(image, x, y, width, height, speed);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameServiceImpl gameService) {
        super.paintSelf(g, jFrame, gameService);

        //boss移动
        if (x > 550 || x < -50) {
            speed = -speed;
        }
        x += speed;

        //boss与子弹碰撞检测
        GameUtils.shellList.forEach(shell -> {
            if (this.getRectangle().intersects(shell.getRectangle())) {
                shell.setX(-100);
                shell.setY(100);
                GameUtils.removeList.add(shell);
                this.life--;

                if (life <= 0) {
                    GameServiceImpl.status = 4;
                }

            }
        });

        //血条绘制
        g.setColor(Color.WHITE);
        g.fillRect(20, 40, 100, 10);
        g.setColor(Color.red);
        g.fillRect(20, 40, life * 100 / 10, 10);
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
