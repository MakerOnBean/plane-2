package com.dk.plane.entity;

import com.dk.plane.service.GameService;
import lombok.*;

import javax.swing.*;
import java.awt.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base {

    /**
     * 图片
     */
    Image image;

    /**
     * x坐标
     */
    int x;

    /**
     * y坐标
     */
    int y;

    /**
     * 宽度
     */
    int width;

    /**
     * 高度
     */
    int height;

    /**
     * 移动速度
     */
    int speed;

    /**
     * 所使用的窗体
     */
    //GameService gameService;

    /**
     * x,y
     */
    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * image，x，y，speed
     */
    public Base(Image image, int x, int y, int speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /**
     * 绘制自身
     */
    public void paintSelf(Graphics g, JFrame jFrame,GameService gameService){
        g.drawImage(image,x,y,null);
    }

    /**
     * 获取矩形，用于碰撞检测
     */
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }


}
