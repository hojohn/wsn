package com.ai.mnt.web.collect;

public interface Dao {
     public void insert(dataStruct datastruc,int[] a);
     public void insertRFID(dataStruct datastruc,int[] a);
     public void updateNode(String nodeid);
}
