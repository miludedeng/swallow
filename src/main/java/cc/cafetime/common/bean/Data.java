package cc.cafetime.common.bean;

/**
 * 返回数据对象
 * Created by liujing on 16/1/10.
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model){
        this.model = model;
    }

    public Object getModel(){
        return model;
    }

}
