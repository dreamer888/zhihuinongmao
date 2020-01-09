package com.yq.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: MySessionListener  
 * @Description:   
 * @deprecated: never used
 */
@Deprecated
public class MySessionListener implements HttpSessionListener {
	
	private static final Logger logger = LoggerFactory.getLogger(MySessionListener.class);
	
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    	logger.info("MySessionListener session add");
    	MySessionContext.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        logger.info("MySessionListener session destroyed session_id: " + session.getId() + "===================================================================");
        MySessionContext.DelSession(session);
    }

}