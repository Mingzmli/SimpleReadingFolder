package com.simple.reading.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> Object Json2Objext(String json,Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static String Obejct2Json(Object object) {

		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
