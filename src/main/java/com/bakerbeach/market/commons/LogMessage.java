package com.bakerbeach.market.commons;


public class LogMessage {
	private Object[] args;
	private String sessionId;
	
	public LogMessage(Object... args) {
		this.args = args;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		
		if (sessionId == null) {
			sessionId = LogContextHolder.getContext().getSessionID();
		}
		
		if (sessionId != null) {
			b.append(sessionId).append(";");
		}
		
		for (int i = 0; i < args.length; i++) {
			if (args[i] != null) {
				b.append(args[i].toString()).append(";");
			} else {
				b.append(";");
			}
		}

		return b.toString();
	}
	
}
