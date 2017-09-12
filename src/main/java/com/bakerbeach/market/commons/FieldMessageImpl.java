package com.bakerbeach.market.commons;

import java.util.Arrays;

public class FieldMessageImpl extends MessageImpl implements FieldMessage {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Object rejectedValue;
	
	public FieldMessageImpl(String type) {
		super(type,"");
	}
	
	public FieldMessageImpl(String type, String name) {
		super(type,"");
		this.name = name;
	}

	public FieldMessageImpl(String name, String type, String code, Object... args) {
		super(name,type, code, null, Arrays.asList(args));
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

}
