package com.dk.plane.entity;

import com.dk.plane.service.GameService;

import javax.swing.*;
import java.awt.*;

public class Explode extends Base {

    /**
     * 爆炸效果图
     */
    static Image[] pic = new Image[16];

    /**
     * 用于记录图片爆炸index
     */
    int explodeCount = 0;

    /**
     * 初始化爆炸效果图
     */
    static {
        for (int i = 0; i < 16; i++) {
            pic[i] = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/explode/e" + (i + 1) + ".gif");
        }
    }


    public Explode(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameService gameService) {
        if (explodeCount < 16) {
            image = pic[explodeCount++];
            super.paintSelf(g, jFrame, gameService);
        }

    }
}
