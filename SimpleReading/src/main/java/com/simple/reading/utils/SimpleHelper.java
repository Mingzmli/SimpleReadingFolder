package com.simple.reading.utils;

import java.util.UUID;



public class SimpleHelper {	
	
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
}