package com.b510.tray;

import com.ai.mnt.web.debug.TPServer2;
 
public class TPserver extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		TPServer2 s=new TPServer2();
		s.init();
		
	}
	


}
