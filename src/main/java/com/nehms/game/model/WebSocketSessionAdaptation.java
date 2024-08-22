package com.nehms.game.model;

import java.io.IOException;
import java.net.URI;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketSessionAdaptation implements Session {
	
	private final WebSocketSession webSocketSession;

	public WebSocketSessionAdaptation(WebSocketSession webSocketSession) {
		this.webSocketSession = webSocketSession;
	}

	@Override
	public String getId() {
		return webSocketSession.getId();
	}

	@Override
	public URI getUri() {
		return webSocketSession.getUri();
	}

	@Override
	public void sendMessage(String message) throws IOException {
		webSocketSession.sendMessage(new TextMessage(message));
	}

}
