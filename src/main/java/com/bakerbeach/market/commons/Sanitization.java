package com.bakerbeach.market.commons;

public class Sanitization {

	public static String sanitizeCode(String key) {
		key = key.toLowerCase();
		key = key.replaceAll("[\\s]", "-");
		key = key.replaceAll("[^a-z_0-9-]", "");
		
		return key;
	}

	public static String sanitizeUrl(String key) {
		key = key.toLowerCase();
		key = key.replaceAll("&", "and");
		key = key.replaceAll("ö", "oe");
		key = key.replaceAll("ü", "ue");
		key = key.replaceAll("ß", "ss");
		key = key.replaceAll("á", "a");
		key = key.replaceAll("è", "e");
		key = key.replaceAll("ä", "ae");
		key = key.replaceAll("[\\s]{1,}", "-");
		key = key.replaceAll("[^a-z_0-9-]", "");
		
		return key;
	}

	public static String sanitizeFileName(String name) {
		name = name.toLowerCase();
		name = name.replaceAll("[\\s]+", "_");
		name = name.replaceAll("[^a-z0-9-_\\.]", "");
		
		return name;
	}
	
}
