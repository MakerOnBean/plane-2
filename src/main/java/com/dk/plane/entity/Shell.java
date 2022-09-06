package com.dk.plane.entity;

import com.dk.plane.service.GameService;

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
    public void paintSelf(Graphics g, JFrame jFrame, GameService gameService) {
        super.paintSelf(g,jFrame,gameService);
        y -= speed;
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
