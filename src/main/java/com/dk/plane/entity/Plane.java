package com.dk.plane.entity;

import com.dk.plane.service.GameService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plane extends Base{

    private Boolean isMouseMove = false;

    public Plane() {
        super();
    }

    public Plane(Image image, int x, int y, int width, int height, int speed) {
        super(image, x, y, width, height, speed);

    }

    @Override
    public void paintSelf(Graphics g, JFrame jFrame,GameService gameService) {
        super.paintSelf(g,jFrame,gameService);
        if (!isMouseMove){
            isMouseMove = true;
            jFrame.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    Plane.super.setX(e.getX() - 11);
                    Plane.super.setY(e.getY() - 16);
                }
            });
        }

        //我方飞机与敌方boss碰撞检测
        if(gameService.getBoss() != null && getRectangle().intersects(gameService.getBoss().getRectangle())){
            GameService.status = 3;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
