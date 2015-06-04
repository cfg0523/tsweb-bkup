package com.techsen.tsweb.sys.interceptor;

import static com.techsen.tsweb.core.util.ValidUtil.isValid;
import static com.techsen.tsweb.sys.util.SubjectUtil.getPrincipal;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

import com.techsen.tsweb.core.domain.BaseEntity;

/**
 * 拦截Service的新增、修改操作<br/>
 * 设置被新增对象的creatBy和createDate<br/>
 * 设置被修改对象的updateBy和updateDate
 */
@SuppressWarnings("unchecked")
public class NewAddAndUpdateEntityAspect {

    /**
     * 在新增之前设置被新增对象的creatBy和createDate
     */
    public <T> void beforeNewAddEntity(JoinPoint jp) {
        if (isValid(jp.getArgs())) {
            for (Object arg : jp.getArgs()) {
                if (arg instanceof BaseEntity) {
                    BaseEntity<T> entity = (BaseEntity<T>) arg;
                    entity.setCreateBy(getPrincipal());
                    entity.setCreateDate(new Date());
                }
            }
        }
    }

    /**
     * 在修改之前设置被修改对象的updateBy和updateDate
     */
    public <T> void beforeUpdateEntity(JoinPoint jp) {
        if (isValid(jp.getArgs())) {
            for (Object arg : jp.getArgs()) {
                if (arg instanceof BaseEntity) {
                    BaseEntity<T> entity = (BaseEntity<T>) arg;
                    entity.setUpdateBy(getPrincipal());
                    entity.setUpdateDate(new Date());
                }
            }
        }
    }
}
