package com.nehms.game.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.nehms.game.model.Session;
import com.nehms.game.model.WebSocketSessionAdaptation;

public class WebSocketHandlerAdaptation implements WebSocketHandler {

	private final SessionHandler sessionHandler;
	
	public WebSocketHandlerAdaptation(SessionHandler sessionHandler) {
		this.sessionHandler = sessionHandler;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	     Session adaptedSession = new WebSocketSessionAdaptation(session);
	        sessionHandler.handleOpenSession(adaptedSession);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	    Session adaptedSession = new WebSocketSessionAdaptation(session);
        sessionHandler.handleMessage(adaptedSession, message.getPayload().toString());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
	    Session adaptedSession = new WebSocketSessionAdaptation(session);
        sessionHandler.handleCloseSession(adaptedSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
