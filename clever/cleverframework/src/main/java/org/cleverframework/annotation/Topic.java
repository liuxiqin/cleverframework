package org.cleverframework.annotation;

import java.lang.annotation.*;

/**
 * 主题
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 17:35ate:2018/7/20
 */
@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Topic {

    String name() default "";
}
