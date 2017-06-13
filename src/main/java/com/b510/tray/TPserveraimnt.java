package com.b510.tray;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class TPserveraimnt extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		TPserver tp=new TPserver();
		tp.setDaemon(true);
		tp.start();
	}

   
    
            
   
        
  
}