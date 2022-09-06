package com.dk.plane.entity;

import com.dk.plane.service.GameService;
import com.dk.plane.utils.GameUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 敌机类
 */
public class Enemy extends Base {
    public Enemy() {
        super();
    }

    public Enemy(Image image, int x, int y, int width, int height, int speed) {
        super(image, x, y, width, height, speed);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameService gameService) {
        super.paintSelf(g,jFrame,gameService);
        y += speed;

        //子弹与敌机碰撞检测
        GameUtils.shellList.forEach(shell -> {
            if (this.getRectangle().intersects(shell.getRectangle())) {
                Explode explode = new Explode(x,y);
                GameUtils.explodeList.add(explode);
                GameUtils.removeList.add(explode);
                this.setX(-200);
                this.setY(200);
                shell.setX(-100);
                shell.setX(100);
                GameUtils.removeList.add(shell);
                GameUtils.removeList.add(this);
                GameService.score++;
            }
        });

        //敌方飞机与我方飞机碰撞检测
        if (this.getRectangle().intersects(gameService.getPlane().getRectangle())) {
            GameService.status = 3;
        }

        //敌方飞机越界处理
        if (y > 600){
            x = -200;
            y = 200;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
