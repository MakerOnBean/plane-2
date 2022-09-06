package com.dk.plane;

import com.dk.plane.win.GameWin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Plane2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Plane2Application.class)
                .headless(false).run(args);
        GameWin gameWin = context.getBean(GameWin.class);
        gameWin.run();
    }

}
