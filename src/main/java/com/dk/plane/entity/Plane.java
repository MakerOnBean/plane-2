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
    public void paintSelf(Graphics g, JFrame jFrame) {
        super.paintSelf(g,jFrame);
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
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
