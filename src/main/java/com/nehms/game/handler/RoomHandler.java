package com.nehms.game.handler;

import com.nehms.game.model.Session;

public class RoomHandler implements SessionHandler {

	@Override
	public void handleOpenSession(Session session) {
		System.out.println("ok");
	}

	@Override
	public void handleMessage(Session session, String message) {
		
	}

	@Override
	public void handleCloseSession(Session session) {
		
	}

	@Override
	public void handleError(Session session, Throwable exception) {
		
	}

}
