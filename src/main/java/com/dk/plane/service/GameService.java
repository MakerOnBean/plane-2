package com.dk.plane.service;

import com.dk.plane.entity.Background;
import com.dk.plane.utils.GameUtils;
import com.dk.plane.win.GameWin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

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
     * 背景对象
     */
    @Autowired
    private Background background;

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
            background.paintSelf(g);
        }
    }

}
