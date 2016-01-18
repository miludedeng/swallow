package cc.cafetime.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by liujing on 16/1/10.
 */
public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将 POJO 转为 JSON
     */
    public static <T> String toJson(T obj){
        String json;
        try{
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch(Exception e){
            LoggerUtil.logger().error("convert POJO to JSON failure",e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * 将 JSON 转为POJO
     */
    public static <T> T fromJson(String json, Class<T> type){
        T pojo;
        try{
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            LoggerUtil.logger().error("convert JSON to POJO failure",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
