package com.dk.plane.config;

import com.dk.plane.entity.Background;
import com.dk.plane.utils.GameUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    @Bean
    public Background background(){
        return new Background(GameUtils.bgImage,0,-2000,2);
    }
}
