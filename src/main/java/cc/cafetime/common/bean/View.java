package cc.cafetime.common.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回视图对象
 * Created by liujing on 16/1/10.
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    /**
     * 模块module
     */
    private String module;


    public View(String path) {
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value){
        model.put(key, value);
        return this;
    }

    public String getPath(){
        return path;
    }

    public Map<String, Object> getModel(){
        return model;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
