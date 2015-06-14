package com.techsen.tsweb.sys.util;

import static com.techsen.tsweb.core.util.ValidUtil.isEmpty;
import static com.techsen.tsweb.core.util.ValidUtil.isNull;

import java.io.File;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techsen.tsweb.sys.annotation.AuthComponent;
import com.techsen.tsweb.sys.annotation.AuthOperation;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.ComponentService;
import com.techsen.tsweb.sys.service.OperationService;

/**
 * 权限资源扫描器
 */
public class AuthResourceScanner {

    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring-*.xml");
    private static ComponentService componentService = ctx.getBean(ComponentService.class);
    private static OperationService operationService = ctx.getBean(OperationService.class);

    public static void main(String[] args) throws Exception {
        scan("com.techsen.tsweb.sys.controller");
    }

    public static void scan(String pkg) throws Exception {
        String path = pkg.replace(".", "/");
        ClassLoader classLoader = AuthResourceScanner.class.getClassLoader();

        File dir = new File(classLoader.getResource(path).getFile());

        for (String fileName : dir.list()) {
            String className = pkg + "." + fileName.substring(0, fileName.indexOf("."));
            Class<?> clazz = classLoader.loadClass(className);
            AuthComponent authComponent = clazz.getAnnotation(AuthComponent.class);
            if (!isNull(authComponent)) {
                String componentName = isEmpty(authComponent.name()) ? clazz.getSimpleName() : authComponent.name();
                String componentType = authComponent.type().toString();
                String componentDesc = isEmpty(authComponent.desc()) ? clazz.getName() : authComponent.desc();
                String componentJavaType = authComponent.javaType() == Object.class ? clazz.getName() : authComponent.javaType().getName();

                Component component = new Component().setName(componentName)
                        .setType(componentType).setDesc(componentDesc)
                        .setJavaType(componentJavaType);

                System.out.println();
                System.out.println(component);
                System.out.println();
                
                componentService.addComponent(component);

                for (Method method : clazz.getDeclaredMethods()) {
                    AuthOperation authOperation = method.getAnnotation(AuthOperation.class);

                    String operationName = isEmpty(authOperation.name()) ? method.getName() : authOperation.name();
                    String operationDiff = authOperation.diff();
                    String operationDesc = isEmpty(authOperation.desc()) ? clazz.getName() + "." + method.getName() : authOperation.desc();
                    int operationAclBit = authOperation.aclBit();

                    Operation operation = new Operation()
                            .setName(operationName).setDiff(operationDiff)
                            .setDesc(operationDesc).setAclBit(operationAclBit)
                            .setComponent(component);

                    System.out.println();
                    System.out.println(operation);
                    System.out.println();

                    operationService.addOperation(operation);
                }
            }
        }
    }

}
