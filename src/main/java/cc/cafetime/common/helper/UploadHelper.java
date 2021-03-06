package cc.cafetime.common.helper;

import cc.cafetime.common.bean.FileParam;
import cc.cafetime.common.bean.FormParam;
import cc.cafetime.common.bean.Param;
import cc.cafetime.common.util.FileUtil;
import cc.cafetime.common.util.LoggerUtil;
import cc.cafetime.common.util.StreamUtil;
import cc.cafetime.common.util.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件上传助手类
 * Created by liujing on 16/1/18.
 */
public class UploadHelper {

    /**
     * Apache Commons FileUpload 提供的 Servlet 文件上传对象
     */
    private static ServletFileUpload servletFileUpload;

    /**
     * 初始化
     */
    public static void init(ServletContext servletContext){
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository));
        int uploadLimit = ConfigHelper.getAppUploadLimit();
        if(uploadLimit !=0){
            servletFileUpload.setFileSizeMax(uploadLimit*1024*1024);
        }
    }

    /**
     * 判断请求是否为 multipart 类型
     */
    public static boolean isMultipart(HttpServletRequest request){
        return ServletFileUpload.isMultipartContent(request);
    }

    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        List<FileParam> fileParamList = new ArrayList<FileParam>();
        try {
            Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if(MapUtils.isNotEmpty(fileItemListMap)){
                for(Map.Entry<String, List<FileItem>> fileItemListEntry : fileItemListMap.entrySet()){
                    String fieldName = fileItemListEntry.getKey();
                    List<FileItem> fileItemList = fileItemListEntry.getValue();
                    if(CollectionUtils.isNotEmpty(fileItemList)){
                        for (FileItem fileItem : fileItemList){
                            if(fileItem.isFormField()){
                                String fieldValue = fileItem.getString(StringUtils.CHAR_SET_UTF8);
                                formParamList.add(new FormParam(fieldName, fieldValue));
                            }else{
                                String fileName = FileUtil.getRealFileName(new String(fileItem.getName().getBytes(),StringUtils.CHAR_SET_UTF8));
                                if(org.apache.commons.lang3.StringUtils.isNotEmpty(fileName)){
                                    long fileSize = fileItem.getSize();
                                    String contentType = fileItem.getContentType();
                                    InputStream inputStream = fileItem.getInputStream();
                                    fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, inputStream));
                                }
                            }
                        }
                    }
                }
            }
        }catch(FileUploadException e){
            LoggerUtil.logger().error("create param failure",e);
            throw new RuntimeException(e);
        }
        return new Param(formParamList,fileParamList);

    }

    /**
     * 上传文件
     * @param
     * @param fileParam
     */
    public static void uploadFile(String basePath, FileParam fileParam) {
        try{
           if(fileParam != null){
               String filePath = basePath + fileParam.getFieldName();
               FileUtil.createFile(filePath);
               InputStream inputStream = new BufferedInputStream(fileParam.getInputStream());
               OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
               StreamUtil.copyStream(inputStream, outputStream);
           }

        }catch(Exception e){
            LoggerUtil.logger().error("upload file failure",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 批量上传文件
     */
    public static void uploadFile(String basePath, List<FileParam> fileParamList){
        try{
            if(CollectionUtils.isNotEmpty(fileParamList)){
                for(FileParam fileParam : fileParamList){
                    uploadFile(basePath, fileParam);
                }
            }
        }catch (Exception e){
            LoggerUtil.logger().error("upload file failure",e);
            throw new RuntimeException(e);
        }
    }
}
