package cc.cafetime.common.annotation;

/**
 *  REST 服务注解
 * Created by liujing on 16/1/22.
 */
public @interface Rest {

    /**
     *  服务名
     */
    String value() default "";
}
