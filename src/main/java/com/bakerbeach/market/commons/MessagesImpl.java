package com.bakerbeach.market.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessagesImpl extends ArrayList<Message> implements Messages {
	private static final long serialVersionUID = 1L;
	
	Map<String,Object> data = new HashMap<String,Object>();

	@Override
	public List<Message> getGlobalMessages() {
		List<Message> result = new LinkedList<Message>();
		for (Message message : this) {
			if (!(message instanceof FieldMessage)) {
				result.add(message);
			}
		}

		return result;
	}

	@Override
	public List<Message> getGlobalMessages(String type) {
		List<Message> result = new LinkedList<Message>();
		for (Message message : this) {
			if (!(message instanceof FieldMessage) && type.equals(message.getType())) {
				result.add(message);
			}
		}

		return result;
	}

	@Override
	public void addGlobalMessage(Message message) {
		add(message);
	}

	@Override
	public void addGlobalCommand(Message message) {
		message.setType(Message.TYPE_COMMAND);
		add(message);
	}

	@Override
	public void addGlobalError(Message message) {
		message.setType(Message.TYPE_ERROR);
		add(message);
	}

	@Override
	public void addGlobalInfo(Message message) {
		message.setType(Message.TYPE_INFO);
		add(message);
	}

	@Override
	public List<Message> getGlobalErrors() {
		return getGlobalMessages(Message.TYPE_ERROR);
	}

	@Override
	public List<Message> getGlobalInfos() {
		return getGlobalMessages(Message.TYPE_INFO);
	}
	
	@Override
	public List<Message> getGlobalCommands() {
		return getGlobalMessages(Message.TYPE_COMMAND);
	}

	@Override
	public List<FieldMessage> getFieldMessages() {
		List<FieldMessage> result = new LinkedList<FieldMessage>();
		for (Message message : this) {
			if (message instanceof FieldMessage) {
				result.add((FieldMessage) message);
			}
		}

		return result;
	}

	@Override
	public List<FieldMessage> getFieldMessages(String type) {
		List<FieldMessage> result = new LinkedList<FieldMessage>();
		for (Message message : this) {
			if (message instanceof FieldMessage && type.equals(message.getType())) {
				result.add((FieldMessage) message);
			}
		}

		return result;
	}

	@Override
	public void addFieldMessage(FieldMessage message) {
		add(message);
	}

	@Override
	public void addFieldError(FieldMessage message) {
		message.setType(Message.TYPE_ERROR);
		add(message);
	}

	@Override
	public boolean hasErrors() {
		for (Message message : this) {
			if (message.getType().equals(Message.TYPE_ERROR)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void addFieldInfo(FieldMessage message) {
		message.setType(Message.TYPE_INFO);
		add(message);
	}

	@Override
	public List<FieldMessage> getFieldErrors() {
		return getFieldMessages(Message.TYPE_ERROR);
	}

	@Override
	public List<FieldMessage> getFieldInfos() {
		return getFieldMessages(Message.TYPE_INFO);
	}

	@Override
	public FieldMessage getFieldMessage(String fieldName) {
		for (Message message : this) {
			if (message instanceof FieldMessage) {
				FieldMessage fieldMessage = (FieldMessage) message;
				if (fieldName.equals(fieldMessage.getName())) {
					return fieldMessage;
				}
			}
		}

		return null;
	}

	@Override
	public FieldMessage getFieldMessage(String fieldName, String type) {
		for (Message message : this) {
			if (message instanceof FieldMessage) {
				FieldMessage fieldMessage = (FieldMessage) message;
				if (fieldName.equals(fieldMessage.getName()) && type.equals(fieldMessage.getType())) {
					return fieldMessage;
				}
			}
		}

		return null;
	}

	@Override
	public FieldMessage getFieldError(String fieldName) {
		return getFieldMessage(fieldName, Message.TYPE_ERROR);
	}

	@Override
	public FieldMessage getFieldInfo(String fieldName) {
		return getFieldMessage(fieldName, Message.TYPE_INFO);
	}
	
	@Override
	public Map<String, Object> getData() {
		return data;
	}
	
	@Override
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append(this.getClass().getName() + " Messages {" + NEW_LINE);

		result.append("Messages: [");
		for (Message message : this) {
			result.append(message).append(",");
		}
		result.append("]");
		result.append("}");

		return result.toString();
	}

}
