package com.techsen.tsweb.sys.util;

import static com.techsen.tsweb.core.util.ValidUtil.isNull;
import static com.techsen.tsweb.core.util.ValidUtil.isEmpty;

import java.io.File;
import java.lang.reflect.Method;

import org.springframework.expression.spel.ast.OpAnd;

import com.sun.corba.se.spi.orb.Operation;
import com.techsen.tsweb.sys.annotation.AuthComponent;
import com.techsen.tsweb.sys.annotation.AuthOperation;
import com.techsen.tsweb.sys.domain.Component;

/**
 * 权限资源扫描器
 */
public class AuthScanner {

    public static void main(String[] args) throws Exception {
        String pkg = "com.techsen.tsweb.sys.controller";
        String path = pkg.replace(".", "/");
        ClassLoader classLoader = AuthScanner.class.getClassLoader();

        File dir = new File(classLoader.getResource(path).getFile());

        for (String fileName : dir.list()) {
            String className = pkg + "."
                    + fileName.substring(0, fileName.indexOf("."));
            Class<?> clazz = classLoader.loadClass(className);
            AuthComponent authComponent = clazz
                    .getAnnotation(AuthComponent.class);
            if (!isNull(authComponent)) {
                String componentName = isEmpty(authComponent.name()) ? clazz
                        .getSimpleName() : authComponent.name();
                String componentType = authComponent.type().toString();
                String componentDesc = isEmpty(authComponent.desc()) ? clazz
                        .getName() : authComponent.desc();
                String componentJavaType = authComponent.javaType() == Object.class ? clazz
                        .getName() : authComponent.javaType().getName();

                Component component = new Component().setName(componentName)
                        .setType(componentType).setDesc(componentDesc)
                        .setJavaType(componentJavaType);

                System.out.println(component);

                for (Method method : clazz.getDeclaredMethods()) {
                    AuthOperation authOperation = method.getAnnotation(AuthOperation.class);
                    
                    String operationName = isEmpty(authOperation.name()) ? method.getName() : authOperation.name();
                    String diff = isEmpty(authOperation.diff()) ? null : authOperation.diff();
                    String desc = isEmpty(authOperation.desc()) ? clazz.getName() + "." + method.getName() : authOperation.desc();
                    int aclBit = authOperation.aclBit();
                    
                }
            }
        }
    }

}
