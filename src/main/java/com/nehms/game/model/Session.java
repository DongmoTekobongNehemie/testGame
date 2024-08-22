package com.nehms.game.model;

import java.io.IOException;
import java.net.URI;

public interface Session {
	    String getId();
	    URI getUri();
	    void sendMessage(String message) throws IOException;
}

