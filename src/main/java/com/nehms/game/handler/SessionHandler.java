package com.nehms.game.handler;

import com.nehms.game.model.Session;

public interface SessionHandler {
	
	void handleOpenSession(Session session);

	void handleMessage(Session session, String message);

	void handleCloseSession(Session session);

	void handleError(Session session, Throwable exception);
}
