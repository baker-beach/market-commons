package com.bakerbeach.market.commons;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class ServiceException extends Exception {	
	protected Messages messages = new MessagesImpl();
	protected Map<String, Object[]> data = new LinkedHashMap<String, Object[]>(3);

	public ServiceException() {
		super();
	}

	public ServiceException(String arg) {
		super(arg);
	}
	
	public ServiceException(Map<String, Object[]> data) {
		super();
		this.data = data;
	}
	
	public ServiceException(Messages messages) {
		this.messages = messages;
	}

	public ServiceException(String key, Object... objects) {
		super();
		this.data.put(key, objects);
	}
	
	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public Messages getMessages() {
		return messages;
	}

	public String getKey() {
		return data.keySet().iterator().next();
	}

	public Object[] getObjects() {
		if (!data.isEmpty()) {
			return data.values().iterator().next();			
		} else {
			return null;
		}
	}
	
	public Map<String, Object[]> getData() {
		return data;
	}

	@Override
	public String getMessage() {		
		if (data.isEmpty()) {
			return super.getMessage();
		} else {
			return new StringBuilder(getClass().getSimpleName()).append(" - ").append(data.keySet().iterator().next()).toString();
		}
	}

}
