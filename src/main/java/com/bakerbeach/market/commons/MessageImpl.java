package com.bakerbeach.market.commons;

import java.util.HashMap;
import java.util.List;

import com.bakerbeach.market.core.api.model.Message;

public class MessageImpl extends HashMap<String, Object> implements Message {
	private static final long serialVersionUID = 1L;

	private String type;
	private String code;
	private Object[] args;

	public MessageImpl(String type) {
		this.type = type;
	}

	public MessageImpl(String type, String code, Object... args) {
		this.type = type;
		this.code = code;
		this.args = args;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Object[] getArgs() {
		return args;
	}

	@Override
	public void setArgs(List<Object> args) {
		this.args = args.toArray();
	}

	@Override
	public void setArgs(Object... args) {
		this.args = args;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append(" Message {" + NEW_LINE);
		result.append(" Type: " + type + NEW_LINE);
		result.append(" Code: " + code + NEW_LINE);
		result.append(" Args: " + args + NEW_LINE);
		result.append("}");

		return result.toString();
	}
}
