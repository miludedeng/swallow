package cc.cafetime.common.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by liujing on 16/1/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
