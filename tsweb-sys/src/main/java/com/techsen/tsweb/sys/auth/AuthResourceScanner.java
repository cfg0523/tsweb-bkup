package com.techsen.tsweb.sys.auth;

import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.core.util.ValidUtil.isEmpty;
import static com.techsen.tsweb.core.util.ValidUtil.isNull;
import static com.techsen.tsweb.core.util.ValidUtil.isValid;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techsen.tsweb.sys.auth.annotation.AuthComponent;
import com.techsen.tsweb.sys.auth.annotation.AuthOperation;
import com.techsen.tsweb.sys.domain.Component;
import com.techsen.tsweb.sys.domain.Operation;
import com.techsen.tsweb.sys.service.ComponentService;
import com.techsen.tsweb.sys.service.OperationService;

public class AuthResourceScanner {

    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring-*.xml");
    private static ClassLoader classLoader = AuthResourceScanner.class.getClassLoader();
    private static ComponentService componentService = ctx.getBean(ComponentService.class);
    private static OperationService operationService = ctx.getBean(OperationService.class);
    
    public static void main(String[] args) {
        removeAllAuthResources();
        List<Class<?>> classList = scanClass("com.techsen.tsweb.sys");
        importAuthResources(classList);
        System.exit(0);
    }
    
    public static void removeAllAuthResources() {
        operationService.removeAll();
        componentService.remoteAll();
    }
    
    /**
     * 遍历给定的集合中的类，<br/>
     * 检查有{@link com.techsen.tsweb.sys.auth.annotation.AuthComponent}注解标注的类，导入组件资源，<br/>
     * 检查有{@link com.techsen.tsweb.sys.auth.annotation.AuthOperation}标注的方法，导入组件操作资源
     */
    public static void importAuthResources(List<Class<?>> classList) {
        if (isValid(classList)) {
            for (Class<?> clazz : classList) {
                AuthComponent authComponent = clazz.getAnnotation(AuthComponent.class);
                if (!isNull(authComponent)) {
                    String componentName = isEmpty(authComponent.name()) ? clazz.getSimpleName() : authComponent.name();
                    String componentType = authComponent.resourceType();
                    String componentDesc = isEmpty(authComponent.desc()) ? clazz.getName() : authComponent.desc();
                    String componentJavaType = authComponent.javaType() == Object.class ? clazz.getName() : authComponent.javaType().getName();
                    
                    Component component = new Component().setName(componentName)
                            .setResourceType(componentType).setDesc(componentDesc)
                            .setJavaType(componentJavaType);
                    componentService.addEntity(component);
                    
                    for (Method method : clazz.getDeclaredMethods()) {
                        AuthOperation authOperation = method.getAnnotation(AuthOperation.class);

                        String operationName = isEmpty(authOperation.name()) ? method.getName() : authOperation.name();
                        String operationDiff = authOperation.diff();
                        String operationDesc = isEmpty(authOperation.desc()) ? clazz.getName() + "." + method.getName() : authOperation.desc();
                        int operationAclBit = authOperation.aclPos();

                        Operation operation = new Operation()
                                .setName(operationName).setDiff(operationDiff)
                                .setDesc(operationDesc).setAclPos(operationAclBit)
                                .setComponent(component);
                        operationService.addEntity(operation);
                    }
                }
            }
        }
    }
    
    /**
     * 扫描给定包下的所有类
     */
    public static List<Class<?>> scanClass(String basePackage) {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        if (isValid(basePackage)) {
            String curpath = basePackage.replace(".", "/");
            File curdir = new File(classLoader.getResource(curpath).getFile());
            if (curdir.exists()) {
                for (File curfile : curdir.listFiles()) {
                    if (curfile.isFile()) {
                        String className = curfile.getName();
                        if (className.endsWith(".class")) {
                            className = className.substring(0, className.indexOf("."));
                            className = basePackage + "." + className;
                            try {
                                classList.add(classLoader.loadClass(className));
                            } catch(Exception e) {
                                throwRuntimeException(e);
                            }
                        }
                    } else {
                        classList.addAll(scanClass(basePackage + "." + curfile.getName()));
                    }
                }
            }
        }
        return classList;
    }
}
