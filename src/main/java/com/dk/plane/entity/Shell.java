package com.dk.plane.entity;

import com.dk.plane.service.impl.GameServiceImpl;
import com.dk.plane.utils.GameUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 我方子弹类
 */
public class Shell extends Base {
    public Shell() {
        super();
    }

    public Shell(Image image, int x, int y, int width, int height, int speed) {
        super(image, x, y, width, height, speed);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameServiceImpl gameService) {
        super.paintSelf(g, jFrame, gameService);
        y -= speed;

        //子弹飞出屏幕后删除
        if (y < 0) {
            x = -100;
            y = 100;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
