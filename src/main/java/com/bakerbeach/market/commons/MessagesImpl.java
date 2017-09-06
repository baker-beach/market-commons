package com.bakerbeach.market.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MessagesImpl implements Messages {
	Map<String, Message> map = new LinkedHashMap<String, Message>();
	Map<String,Object> data = new HashMap<String,Object>();

	@Override
	public void add(Message message) {
		map.put(message.getId(), message);
	}

	@Override
	public void add(Messages messages) {
		for (Message message : messages.getAll()) {
			add(message);
		}
	}

	@Override
	public void addAll(List<Message> messageList) {
		for (Message message : messageList) {
			add(message);
		}
	}

	@Override
	public List<Message> getAll() {
		List<Message> list = new ArrayList<>();
		map.values().forEach(m -> list.add(m));
		return list;
	}

	@Override
	public List<Message> getGlobalMessages() {
		List<Message> list = new ArrayList<Message>();
		for (Message message : map.values()) {
			if (!(message instanceof FieldMessage)) {
				list.add(message);
			}
		}

		return list;	
	}

	@Override
	public List<Message> getGlobalMessages(String type) {
		List<Message> list = new ArrayList<Message>();
		for (Message message : map.values()) {
			if (!(message instanceof FieldMessage) && type.equals(message.getType())) {
				list.add(message);
			}
		}

		return list;	
	}

	@Override
	@Deprecated
	public void addGlobalMessage(Message message) {
		add(message);
	}

	@Override
	@Deprecated
	public void addGlobalCommand(Message message) {
		message.setType(Message.TYPE_COMMAND);
		add(message);
	}

	@Override
	@Deprecated
	public void addGlobalError(Message message) {
		message.setType(Message.TYPE_ERROR);
		add(message);
	}

	@Override
	@Deprecated
	public void addGlobalInfo(Message message) {
		message.setType(Message.TYPE_INFO);
		add(message);
	}

	@Override
	@Deprecated
	public List<Message> getGlobalErrors() {
		return getGlobalMessages(Message.TYPE_ERROR);
	}

	@Override
	@Deprecated
	public List<Message> getGlobalInfos() {
		return getGlobalMessages(Message.TYPE_INFO);
	}

	@Override
	@Deprecated
	public List<Message> getGlobalCommands() {
		return getGlobalMessages(Message.TYPE_COMMAND);
	}

	@Override
	@Deprecated
	public void addFieldMessage(FieldMessage message) {
		add(message);
	}

	@Override
	@Deprecated
	public void addFieldError(FieldMessage message) {
		message.setType(Message.TYPE_ERROR);
		add(message);
	}

	@Override
	public boolean hasErrors() {
		for (Message message : map.values()) {
			if (message.getType().equals(Message.TYPE_ERROR)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	@Deprecated
	public void addFieldInfo(FieldMessage message) {
		message.setType(Message.TYPE_INFO);
		add(message);
	}

	@Override
	@Deprecated
	public List<FieldMessage> getFieldErrors() {
		return getFieldMessages(Message.TYPE_ERROR);
	}

	@Override
	@Deprecated
	public List<FieldMessage> getFieldInfos() {
		return getFieldMessages(Message.TYPE_INFO);
	}

	@Override
	public List<FieldMessage> getFieldMessages() {
		List<FieldMessage> list = new ArrayList<FieldMessage>();
		for (Message message : map.values()) {
			if (message instanceof FieldMessage) {
				list.add((FieldMessage) message);
			}
		}

		return list;
	}
	
	@Override
	public List<FieldMessage> getFieldMessages(String type) {
		List<FieldMessage> list = new ArrayList<FieldMessage>();
		for (Message message : map.values()) {
			if (message instanceof FieldMessage && type.equals(message.getType())) {
				list.add((FieldMessage) message);
			}
		}

		return list;
	}

	@Override
	public FieldMessage getFieldMessage(String fieldName) {
		for (Message message : map.values()) {
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
		for (Message message : map.values()) {
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
	@Deprecated
	public FieldMessage getFieldError(String fieldName) {
		return getFieldMessage(fieldName, Message.TYPE_ERROR);
	}

	@Override
	@Deprecated
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
	public void clear() {
		map.clear();
	}
	
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

}
