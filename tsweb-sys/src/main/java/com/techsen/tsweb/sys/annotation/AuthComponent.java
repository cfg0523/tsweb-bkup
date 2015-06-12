package com.techsen.tsweb.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthComponent {
    
    /**
     * 权限资源的名称
     */
    public String name() default "";
    
    /**
     * 权限资源的类型
     */
    public AuthComponentType type() default AuthComponentType.Controller;
    
    /**
     * 权限资源的描述
     */
    public String desc() default "";
    
    /**
     * 权限资源的java类型
     */
    public Class<?> javaType() default Object.class;
}
