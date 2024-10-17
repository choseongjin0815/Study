package net.fullstack7.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	private int sessionCnt;

    public SessionListener() {
        // TODO Auto-generated constructor stub
    }
    //동시접속자가 얼마인가를 알게되는 로직

    public void sessionCreated(HttpSessionEvent se)  { 
        	sessionCnt++;
        	System.out.println("===================================================");
        	System.out.println("sessionListener create");
        	System.out.println("[리스너]세션 생성" + se.getSession().getId());
        	System.out.println("[리스너]세션 접속 인원수 카운트" + this.sessionCnt);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	sessionCnt--;
    	System.out.println("[리스너]세션 소멸" + se.getSession().getId());
    	System.out.println("[리스너]세션 접속 인원수 카운트" + this.sessionCnt);
    	System.out.println("sessionListener destroyed");
    	System.out.println("===================================================");
    }
	
}
