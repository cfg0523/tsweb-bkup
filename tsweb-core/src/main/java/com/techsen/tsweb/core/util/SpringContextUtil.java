package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 以静态变量保存Spring ApplicationContext，<br/>
 * 可在代码任何地方任何时候获取ApplicaitonContext
 */
@Component
@Lazy(false)
@SuppressWarnings("unchecked")
public class SpringContextUtil implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext;

	/**
	 * 获取ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		assertApplicationContextInjected();
		return applicationContext;
	}

	/**
	 * 从ApplicationContext中根据id或name获取Bean
	 */
	public static <T> T getBean(String name) {
		assertApplicationContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从ApplicationContext中根据类型获取Bean
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertApplicationContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 实现ApplicationContextAware接口，注入ApplicationContext到静态变量中
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 实现DisposableBean接口，在ApplicationContext关闭时清理静态变量
	 */
	@Override
	public void destroy() throws Exception {
	    applicationContext = null;
	}

	/**
	 * 断言ApplicationContext不为空，为空时抛出运行时异常
	 */
	private static void assertApplicationContextInjected() {
	    if (applicationContext == null) {
	        throwRuntimeException("Spring ApplicationContext未被注入");
	    }
	}
}