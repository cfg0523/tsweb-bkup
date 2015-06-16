package com.techsen.tsweb.sys.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.techsen.tsweb.sys.auth.AuthComponentType;

/**
 * 用了标识组件资源，以便于被权限资源扫描器扫描 权限资源扫描器:<br/>
 * {@link com.techsen.tsweb.sys.auth.AuthResourceScanner}
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthComponent {

    /**
     * 权限资源的名称<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值为不包含包名的类名
     */
    public String name() default "";

    /**
     * 权限资源的类型<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值为
     * {@link com.techsen.tsweb.sys.auth.annotation.AuthComponentType.Controller}
     */
    public AuthComponentType type() default AuthComponentType.Controller;

    /**
     * 权限资源的描述<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值为空字符串
     */
    public String desc() default "";

    /**
     * 权限资源的java类型<br/>
     * 没有指定时，被{@link com.techsen.tsweb.sys.auth.AuthResourceScanner}扫描时，值类的全名
     */
    public Class<?> javaType() default Object.class;
}
