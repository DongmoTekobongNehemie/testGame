package com.nehms.game.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.nehms.game.handler.SessionHandler;
import com.nehms.game.handler.WebSocketHandlerAdaptation;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
	

    private final SessionHandler sessionHandler;

    public WebSocketConfiguration(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        WebSocketHandler webSocketHandler = new WebSocketHandlerAdaptation(sessionHandler);
        registry.addHandler(webSocketHandler, "/game/{room}").setAllowedOrigins("*");
    }
    

}
