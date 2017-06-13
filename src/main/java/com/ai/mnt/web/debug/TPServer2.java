package com.ai.mnt.web.debug;
import java.io.DataInputStream;  
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.mnt.persistence.device.WsnHardwareInfoMapper;
import com.ai.mnt.service.device.WsnHardwareInfoService;

public class TPServer2 {
	private static final int port=0571;
	@Autowired
	WsnHardwareInfoService wsnHardwareInfoService;
	public void init()  { 
        try {
            ServerSocket ss=new ServerSocket(port);
            while(true){
                Socket socket=ss.accept();
                new HandlerThread(socket);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        }

	private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket ss){
            socket=ss;
            new Thread(this).start();
        }
       
        public void run() {
            // TODO Auto-generated method stub
            DataInputStream input;
            String param[]=new String[2];
            String yidong="";
            try {
                input = new DataInputStream(socket.getInputStream());
                String clientInputStr = input.readUTF();
                String a[]=clientInputStr.split(",");
                System.out.println(a);
                for(String b:a){
                    if(b.trim().equals("mnt_dev"))
                        param[0]=b;
                    if(b.trim().equals("RFID"))
                        param[1]=b;
                    if(b.trim().equals("1")){
                        //调用单点调试查看
                        List<Map<String,Object>> wsnDebugInfos= wsnHardwareInfoService.findAllWsnDebugInfo(3);
                        for(Map<String,Object> map:wsnDebugInfos){
                            if(map.get("info_three")!=null){
                               yidong+=map.get("info_three")+",";
                               System.out.println(yidong);
                            }else{
                                yidong+=",";
                                System.out.println(yidong);
                            }
                        }
                    }
                       
                }
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
                if(param[0]==null&&param[1]==null){
                    if(yidong!=""&&!clientInputStr.trim().equals(",")){
                        out.writeUTF(yidong);
                    }else{
                    out.writeUTF("END");
                    }
                }
                else{
                    out.writeUTF("successful");
                }
                out.close();    
                input.close(); 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
}}
	

}
