package com.bakerbeach.market.commons;

import java.util.List;

public interface Message {

	public final static String TYPE_INFO = "info";
	public final static String TYPE_ERROR = "error";
	public final static String TYPE_WARNING = "error";
	public final static String TYPE_COMMAND = "command";

	public final static String TAG_BOX = "box";
	public final static String TAG_CART = "cart";

	String getId();

	void setId(String id);

	String getType();

	void setType(String type);

	String getCode();

	void setCode(String code);

	Object[] getArgs();

	void setArgs(List<Object> args);

	void setArgs(Object... args);

	String toString();

	List<String> getTags();

	void setTags(List<String> tags);

}