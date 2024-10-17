package net.fullstack7.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;


public class SessionAttributeListener implements HttpSessionAttributeListener {

 
    public SessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }


    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("===================================================");
    	System.out.println("sessionattrListener attributereplaced");
    	System.out.println("[리스너]세션 속성 변경" + se.getName() + " = " + se.getValue());
    	System.out.println("===================================================");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("===================================================");
    	System.out.println("sessionattrListener attributeremoved");
    	System.out.println("[리스너]세션 제거" + se.getName() + " = " + se.getValue());
    	System.out.println("===================================================");
    }


    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("===================================================");
    	System.out.println("sessionattrListener attributeadded");
    	System.out.println("[리스너]세션 추가" + se.getName() + " = " + se.getValue());
    	System.out.println("===================================================");
    }
	
}
