package com.bakerbeach.market.commons;

import java.util.List;
import java.util.Map;

public interface Messages {

	void add(Message message);

	void add(Messages messages);
	
	void addAll(List<Message> messages);

	List<Message> getAll();

	void clear();
	
	List<Message> getGlobalMessages();

	List<Message> getGlobalMessages(String type);

	void addGlobalMessage(Message message);

	void addGlobalCommand(Message message);

	void addGlobalError(Message message);

	void addGlobalInfo(Message message);

	List<Message> getGlobalErrors();

	List<Message> getGlobalInfos();

	List<Message> getGlobalCommands();

	List<FieldMessage> getFieldMessages();

	List<FieldMessage> getFieldMessages(String type);

	void addFieldMessage(FieldMessage message);

	void addFieldError(FieldMessage message);

	boolean hasErrors();

	void addFieldInfo(FieldMessage message);

	List<FieldMessage> getFieldErrors();

	List<FieldMessage> getFieldInfos();

	FieldMessage getFieldMessage(String fieldName);

	FieldMessage getFieldMessage(String fieldName, String type);

	FieldMessage getFieldError(String fieldName);

	FieldMessage getFieldInfo(String fieldName);

	Map<String, Object> getData();

	void setData(Map<String, Object> data);

	boolean isEmpty();

}
