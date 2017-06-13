package com.ai.mnt.service.sys;

import java.io.File;
import java.io.IOException;

public class FileDemo {
 
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\我的文档");
        if (!file.exists()) {
            file.createNewFile();
        }
     File [] files =file.listFiles();
        for (File file2 : files) {
            //System.out.println(file2);
            if (file2.isDirectory()) {
                
            }
        }
        
    }
}
