package com.dk.plane.win;

import com.dk.plane.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 窗体设计
 */
@Component
public class GameWin extends JFrame {

    @Autowired
    private GameService gameService;

    @Value("${game.width}")
    int width;

    @Value("${game.height}")
    int height;



    public void init(){
        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("飞机大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void paint(Graphics g) {
        gameService.statusHandle(g,this);
    }



    public void run(){
        init();
    }
}
