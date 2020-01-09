package com.wqwy.zhnm.base.component.utils;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
	
	public static String AsJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	    	log.error(e.getMessage());
	        throw new RuntimeException(e);
	    }
	}
	
	public static String AsJsonStringWithoutGetAndSetAndCreator2(final Object obj) {
	    try {
	    	ObjectMapper om = new ObjectMapper()
	    			.setVisibility(PropertyAccessor.ALL, Visibility.NONE)
	    			.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	        return om.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	    } catch (Exception e) {
	    	log.error(e.getMessage());
	        throw new RuntimeException(e);
	    }
	}
	
	public static Object AsJsonObject(final String str, Class<?> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		Object o = null;
		try {
			o = mapper.readValue(str, clazz);
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return o;
	}
	
	public static Object AsJsonObject(final Map<?, ?> map, Class<?> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		Object o = null;
	    try {
	        String str = new ObjectMapper().writeValueAsString(map);
			o = mapper.readValue(str, clazz);
	    } catch (Exception e) {
	    	log.error(e.getMessage());
	        throw new RuntimeException(e);
	    }
	    return o;
	}
	
}
