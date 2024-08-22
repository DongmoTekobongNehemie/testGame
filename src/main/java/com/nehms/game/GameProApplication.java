package com.nehms.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nehms.game.handler.RoomHandler;
import com.nehms.game.handler.SessionHandler;

@SpringBootApplication
public class GameProApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameProApplication.class, args);
	}
	
	@Bean
     SessionHandler roomHandler() {
        return new RoomHandler();
    }
}
