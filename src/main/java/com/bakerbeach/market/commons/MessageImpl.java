package com.bakerbeach.market.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MessageImpl extends HashMap<String, Object> implements Message {
	private static final long serialVersionUID = 1L;

	private String id;
	private String type;
	private String code;
	private List<Object> args = new ArrayList<>();
	private List<String> tags = new ArrayList<>();

	public MessageImpl(String id, String type, String code, List<String> tags, List<Object> args) {
		this.id = id;
		this.type = type;
		this.code = code;
		this.tags.addAll(tags);
		this.args = args;
	}
	
	@Deprecated
	public MessageImpl(String type, String code) {
		this.type = type;
		this.code = code;
		tags.add("box");
	}
	
	public MessageImpl(String type, String code, String tag) {
		this.type = type;
		this.code = code;
		tags.add(tag);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
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
		return args.toArray();
	}

	@Override
	public void setArgs(List<Object> args) {
		this.args = args;
	}

	@Override
	public void setArgs(Object... args) {
		this.args = Arrays.asList(args);
	}

	@Override
	public List<String> getTags() {
		return tags;
	}

	@Override
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Message) {
			return ((Message) other).getCode().equals(getCode());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append(" message {" + NEW_LINE);
		result.append(" id: " + id + NEW_LINE);
		result.append(" type: " + type + NEW_LINE);
		result.append(" code: " + code + NEW_LINE);
		result.append(" tags: " + tags + NEW_LINE);
		result.append(" args: " + args + NEW_LINE);
		result.append("}");

		return result.toString();
	}
}
