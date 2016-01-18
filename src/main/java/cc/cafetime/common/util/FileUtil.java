package cc.cafetime.common.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * 文件操作工具类
 * Created by liujing on 16/1/18.
 */
public class FileUtil {
    /**
     * 获取真是文件名 (自动去掉文件路径)
     */
    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    /**
     * 创建文件
     */
    public static File createFile(String filePath){
        File file;
        try{
            file = new File(filePath);
            File parentDir = file.getParentFile();
            if(!parentDir.exists()){
                FileUtils.forceMkdir(parentDir);
            }
        }catch(Exception e){
            LoggerUtil.logger().error("create file failure", e);
            throw new RuntimeException(e);
        }
        return file;
    }
}
