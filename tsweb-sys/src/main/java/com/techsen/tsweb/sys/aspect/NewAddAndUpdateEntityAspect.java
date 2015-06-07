package com.techsen.tsweb.sys.aspect;

import static com.techsen.tsweb.core.util.UUIDUtil.uuid;
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
        System.out.println("-------------before newAdd-----------------");
        if (isValid(jp.getArgs())) {
            for (Object arg : jp.getArgs()) {
                if (arg instanceof BaseEntity) {
                    BaseEntity<T> entity = (BaseEntity<T>) arg;
                    String uuid = uuid();
                    System.out.println("----setId: " + uuid + "----");
                    entity.setId(uuid); // 设置实体的id
                    entity.setCreateBy(getPrincipal()); // 设置创建者id
                    entity.setCreateDate(new Date()); // 设置创建时间
                }
            }
        }
        System.out.println("-------------after  newAdd-----------------");
    }

    /**
     * 在修改之前设置被修改对象的updateBy和updateDate
     */
    public <T> void beforeUpdateEntity(JoinPoint jp) {
        System.out.println("-------------before update-----------------");
        if (isValid(jp.getArgs())) {
            for (Object arg : jp.getArgs()) {
                if (arg instanceof BaseEntity) {
                    BaseEntity<T> entity = (BaseEntity<T>) arg;
                    entity.setUpdateBy(getPrincipal()); // 设置修改者id
                    entity.setUpdateDate(new Date()); // 设置修改时间
                }
            }
        }
        System.out.println("-------------after  update-----------------");
    }
}
