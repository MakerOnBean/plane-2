package com.dk.plane.utils;

import com.dk.plane.entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具包
 */
public class GameUtils {
    /**
     * 背景图片
     */
    public static Image bgImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/bg.jpg");

    /**
     * boos图片
     */
    public static Image bossImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/boss.png");

    /**
     * 爆炸图片
     */
    public static Image explodeImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/explode/e6.gif");

    /**
     * 我方飞机图片
     */
    public static Image planeImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/plane.png");

    /**
     * 我方子弹图片
     */
    public static Image shellImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/shell.png");

    /**
     * 我方子弹图片
     */
    public static Image bulletImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/bullet.png");

    /**
     * 敌方战机图片
     */
    public static Image enemyImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/enemy.png");

    /**
     * 游戏物体集合
     */
    public static List<Base> gameList = new ArrayList<>();

    /**
     * 要删除的元素集合
     */
    public static List<Base> removeList = new ArrayList<>();

    /**
     * 我方子弹集合
     */
    public static List<Shell> shellList = new ArrayList<>();

    /**
     * 敌方子弹集合
     */
    public static List<Bullet> bulletList = new ArrayList<>();

    /**
     * 敌方战机集合
     */
    public static List<Enemy> enemyList = new ArrayList<>();

    /**
     * 爆炸效果集合
     */
    public static List<Explode> explodeList = new ArrayList<>();

    /**
     * 绘制字符串
     */
    public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y) {
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋", Font.BOLD, size));
        gImage.drawString(str, x, y);
    }
}
