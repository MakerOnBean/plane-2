package com.dk.plane.service;

import com.dk.plane.entity.*;
import com.dk.plane.utils.GameUtils;
import com.dk.plane.win.GameWin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * 业务逻辑
 */
@Component
@Getter
@Setter
public class GameService {

    /**
     * 状态码
     */
    @Value("${game.defaultStatus}")
    public static int status;

    /**
     * 游戏重绘次数
     */
    @Value("${game.defaultCount}")
    private static int count;

    /**
     * 分数
     */
    @Value("${game.defaultScore}")
    public static int score;

    /**
     * 敌机生成数量
     */
    @Value("${game.defaultEnemyCount}")
    private static int enemyCount;

    /**
     * 背景对象
     */
    @Autowired
    private Background background;

    /**
     * 飞机对象
     */
    @Autowired
    private Plane plane;

    /**
     * boss对象
     */
    private Boss boss;


    /**
     * 状态操作处理器
     * @param g 画布
     * @param jFrame 窗体对象
     */
    public void statusHandle(Graphics g , JFrame jFrame){
        if (status == 0){
            g.drawImage(GameUtils.bgImage,0,0,jFrame);
            g.drawImage(GameUtils.bossImage, 220, 120, null);
            g.drawImage(GameUtils.explodeImage, 270, 350, null);

            //设置字体
            GameUtils.drawWord(g,"点击开始游戏",Color.yellow,40,180,300);
        }
        if (status == 1){
            createObj();
            //添加爆炸图画
            GameUtils.gameList.addAll(GameUtils.explodeList);

            for(int i = 0 ;i < GameUtils.gameList.size(); i++){
                Base gameObj = GameUtils.gameList.get(i);
                gameObj.paintSelf(g,jFrame,this);
            }
            GameUtils.gameList.removeAll(GameUtils.removeList);
        }
        if (status == 3) {
            //当游戏失败 状态码为3
            //设置背景
            g.drawImage(GameUtils.explodeImage, plane.getX()-35, plane.getY()-50, jFrame);

            //设置字体
            GameUtils.drawWord(g,"游戏失败",Color.RED,50,180,300);
        }
        if (status == 4) {
            //当游戏通关 状态码为4
            //设置背景
            g.drawImage(GameUtils.explodeImage, boss.getX()+30, boss.getY()-50, jFrame);

            //设置字体
            GameUtils.drawWord(g,"游戏通关",Color.GREEN,50,190,300);
        }
        //绘制记分面板
        GameUtils.drawWord(g,score + " 分",Color.GREEN,40,30,100);
        count++;
    }

    /**
     * 创建子弹、敌机
     */
    private void createObj(){
        if (count % 15 == 0) {
            //我方子弹
            GameUtils.shellList.add(new Shell(GameUtils.shellImage, plane.getX() + 3, plane.getY() - 16, 14, 25, 5));
            GameUtils.gameList.add(GameUtils.shellList.get(GameUtils.shellList.size() - 1));
        }
        if (count % 15 == 0){
            //敌机
            GameUtils.enemyList.add(new Enemy(GameUtils.enemyImage,((int)(Math.random()*12)*50),0,49,36,5));
            GameUtils.gameList.add(GameUtils.enemyList.get(GameUtils.enemyList.size() - 1));
            enemyCount++;
        }
        if (count % 15 == 0 && null != boss) {
            //敌方子弹
            GameUtils.bulletList.add(new Bullet(GameUtils.bulletImage, boss.getX() + 76, boss.getY() + 85, 15, 25, 5));
            GameUtils.gameList.add(GameUtils.bulletList.get(GameUtils.bulletList.size() - 1));
        }
        if (enemyCount > 1 && null == boss){
            boss = new Boss(GameUtils.bossImage,255,35,155,100,5);
            GameUtils.gameList.add(boss);
        }
    }

    /**
     * 将单实例的背景和飞机添加到gameList中
     */
    @PostConstruct
    void addObjToGameList(){
        GameUtils.gameList.add(background);
        GameUtils.gameList.add(plane);
    }
}
