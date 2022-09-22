package com.dk.plane.entity;

import com.dk.plane.service.impl.GameServiceImpl;
import com.dk.plane.utils.GameUtils;

import javax.swing.*;
import java.awt.*;

public class Bullet extends Base {
    public Bullet(Image image, int x, int y, int width, int height, int speed) {
        super(image, x, y, width, height, speed);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameServiceImpl gameService) {
        super.paintSelf(g, jFrame, gameService);
        y += speed;
        //敌方子弹与飞机碰撞检测
        if (this.getRectangle().intersects(gameService.getPlane().getRectangle())) {
            GameServiceImpl.status = 3;
        }



        //敌方子弹越界后处理
        if (y > 600) {
            x = -300;
            y = 300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();

    }
}
