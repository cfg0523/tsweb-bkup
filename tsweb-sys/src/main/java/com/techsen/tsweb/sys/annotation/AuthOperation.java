package com.techsen.tsweb.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthOperation {

    /**
     * 组件操作方法的名称
     */
    public String name() default "";

    /**
     * 组件操作方法的区分字段<br/>
     * 用来区分重载的同名方法
     */
    public String diff() default "";

    /**
     * 组件操作方法的的功能描述
     */
    public String desc() default "";

    /**
     * 标识此组件操作方法的权限位
     */
    public int aclBit();

}
