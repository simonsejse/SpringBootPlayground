package com.simonwinther.Refresh.utility;

import java.io.File;

public class FileUtil {
    public static void printAllFiles(File curDir) {
        File[] filesList = curDir.listFiles();
        if (filesList == null) return;
        for(File f : filesList){
            if(f.isDirectory())
                printAllFiles(f);
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }

    }
}
