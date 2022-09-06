package com.dk.plane.win;

import com.dk.plane.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 窗体设计
 */
@Component
public class GameWin extends JFrame {

    /**
     * 游戏业务处理对象
     */
    @Autowired
    private GameService gameService;

    /**
     * 窗体宽度
     */
    @Value("${game.width}")
    private int width;

    /**
     * 窗体高度
     */
    @Value("${game.height}")
    private int height;

    /**
     * 双缓存图片
     */
    private Image offScreenImage;


    /**
     * 初始化方法
     */
    public void init(){
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("飞机大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //鼠标监听
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && GameService.status == 0){
                    GameService.status = 1;
                    repaint();
                }
            }
        });

        while (true){
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绘画方法
     */
    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width,height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        gameService.statusHandle(gImage,this);
        g.drawImage(offScreenImage,0,0,null);
    }



    public void run(){
        init();
    }
}
