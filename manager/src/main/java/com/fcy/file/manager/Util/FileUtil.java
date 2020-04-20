package com.fcy.file.manager.Util;

import java.io.File;
import java.util.logging.Logger;

public class FileUtil {
    private static Logger logger = Logger.getLogger(FileUtil.class.getName());
    public static boolean exists(String path,String name){
        File file=new File(path);
        return file.exists();
    }
}
