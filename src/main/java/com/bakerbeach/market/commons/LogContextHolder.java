package com.bakerbeach.market.commons;

public class LogContextHolder {
	private static final ThreadLocal<LogContext> contextHolder = new ThreadLocal<LogContext>();

	public static LogContext getContext() {
		LogContext context = contextHolder.get();
		if (context == null) {
			context = new LogContext();
			contextHolder.set(context);
		}

		return context;
	}
}
