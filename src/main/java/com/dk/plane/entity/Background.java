package com.dk.plane.entity;

import com.dk.plane.service.impl.GameServiceImpl;

import javax.swing.*;
import java.awt.*;

public class Background extends Base {
    public Background() {
        super();
    }

    public Background(Image image, int x, int y, int speed) {
        super(image, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame, GameServiceImpl gameService) {
        super.paintSelf(g, jFrame, gameService);
        y += speed;
        if (y > 0) {
            y = -2000;
        }
    }
}
