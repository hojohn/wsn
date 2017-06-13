package com.ai.mnt.web.debug;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingIP {
    private Queue<String> allIp;
    private int fetchedNum = 0; // 已经取得的任务数量，每次从队列中取一个ip就加1
    List<Map<String,Object>> pingList;
    public PingIP(List<Map<String,Object>> list) {
        pingList=list;
        allIp=new LinkedList<String>();
        for(Map<String, Object> map:pingList){
            String p=((String)map.get("net_ip")).trim();
            allIp.add(p);}
        }

    public List<Map<String,Object>> startPing() {
        // 创建一个线程池，多个线程同时跑
        int threadNum = pingList.size();
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new PingRunner());
        }
        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pingList;
    }
    private class PingRunner implements Runnable {
        private String taskIp = null;
        public void run() {
            try {
                while ((taskIp = getIp()) != null) {
                    InetAddress addr = InetAddress.getByName(taskIp);
                    if (addr.isReachable(5000)) {
                        for(Map<String,Object> m:pingList){
                            if (((String)m.get("net_ip")).trim().equals(taskIp)) {
                               m.put("state", "连接正常");
                            }
                        }
                    } else {
                        for(Map<String,Object> m:pingList){
                            if (((String)m.get("net_ip")).trim().equals(taskIp)) {
                               m.put("state", "连接失败");
                    }
                }
            }}} catch (SocketException e) {
                System.out.println("host ["+taskIp+"] permission denied");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public String getIp() {
        String ip = null;
        synchronized (allIp) {
            ip = allIp.poll();
        }
        if (ip != null) {
            fetchedNum++;
        }
        return ip;
    }
    }

