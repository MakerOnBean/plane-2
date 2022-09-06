package com.dk.plane.service;

import com.dk.plane.entity.Background;
import com.dk.plane.entity.Base;
import com.dk.plane.entity.Plane;
import com.dk.plane.entity.Shell;
import com.dk.plane.utils.GameUtils;
import com.dk.plane.win.GameWin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * 业务逻辑
 */
@Component
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
            List<Base> gameList = GameUtils.gameList;
            for (int i = 0; i < gameList.size(); i++){
                gameList.get(i).paintSelf(g,jFrame);
            }
        }
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
