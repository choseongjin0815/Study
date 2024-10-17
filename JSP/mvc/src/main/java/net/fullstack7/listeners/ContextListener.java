package net.fullstack7.listeners;

import java.util.Enumeration;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


public class ContextListener implements ServletContextListener {

    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("====================================");
    	System.out.println("ContextListener START");
    	System.out.println("ContextListener >> contextInitialized");
    	System.out.println("컨텍스트 객체 리스너 동작 확인");
    	Enumeration<String> apps = sce.getServletContext().getInitParameterNames();
    	while(apps.hasMoreElements()) {
    		System.out.println("컨텍스트 객체 매개변수 확인 : " + apps.nextElement());
    	}
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	Enumeration<String> apps = sce.getServletContext().getInitParameterNames();
    	while(apps.hasMoreElements()) {
    		System.out.println("컨텍스트 객체 매개변수 소멸 확인 : " + apps.nextElement());
    	}
    	System.out.println("ContextListener END");
    	System.out.println("====================================");
    	
    }
	
}
