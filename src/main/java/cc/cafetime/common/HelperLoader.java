package cc.cafetime.common;

import cc.cafetime.common.helper.*;
import cc.cafetime.common.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by liujing on 16/1/10.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> clazz : classList){
            ClassUtil.loadClass(clazz.getName(), true);
        }
    }

}
