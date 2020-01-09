package com.yq.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class MySessionContext {
	
	private static final Logger logger = LoggerFactory.getLogger(MySessionContext.class);
	
    private static Map<String,Object> mymap = new HashMap<String,Object>();

    public static synchronized void AddSession(HttpSession session) {
    	Gson g = new Gson();
    	logger.info("do session add: " + g.toJson(session));
        if (session != null) {
        	logger.info("do session update session_id: " + session.getId());
        	logger.info("update session from: " + g.toJson(mymap.get(session.getId())));
        	logger.info("to: " + g.toJson(session));
            mymap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
    	logger.info("do session delete session_id: " + session.getId());
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
        return null;
        return (HttpSession) mymap.get(session_id);
    }

}