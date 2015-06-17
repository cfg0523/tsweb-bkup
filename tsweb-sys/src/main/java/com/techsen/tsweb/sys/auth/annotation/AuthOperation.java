package com.techsen.tsweb.sys.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 组件操作方法资源，标识在组件资源的方法之上，<br/>
 * 组件资源扫描器扫描到方法时会检查标识在方法之上的该注解<br/>
 * 组件资源扫描器：{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthOperation {

    /**
     * 组件操作方法的名称<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，默认值为方法名
     */
    public String name() default "";

    /**
     * 组件操作方法的区分字段<br/>
     * 用来区分重载的同名方法<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值空字符串
     */
    public String diff() default "";

    /**
     * 组件操作方法的的功能描述<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值空字符串
     */
    public String desc() default "";

    /**
     * 标识此组件操作方法的权限位<br/>
     * 该属性必须被指定，并且在同一个组件名下其值不能重复，<br/>
     * 因为int的存储占32bit，所以即在同一个组件名下只能有32个aclBit值，<br/>
     * 也就是只能拥有32个方法资源
     */
    public int aclPos();

}
