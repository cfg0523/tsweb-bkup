package com.techsen.tsweb.core.domain;

import java.util.Date;

/**
 * 所有业务实体对象的基类
 */
@SuppressWarnings("serial")
public abstract class BaseEntity<T> extends BaseObject<T> {

    /**
     * 推荐采用32位字符串类型的UUID值
     */
    protected String id;
    protected String createBy;
    protected Date createDate;
    protected String updateBy;
    protected Date updateDate;
    protected String remark;
    
    /**
     * 默认构造方法
     */
    public BaseEntity() {
    }

    /**
     * 公共的hashCode方法
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * 公共的equals方法
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity<T> other = (BaseEntity<T>) obj;
        if (this.id == null) {
            return other.id == null;
        } else {
            return this.id.equals(other.id);
        }
    }

    public String getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    public T setId(String id) {
        this.id = id;
        return (T) this;
    }

    public String getCreateBy() {
        return createBy;
    }

    @SuppressWarnings("unchecked")
    public T setCreateBy(String createBy) {
        this.createBy = createBy;
        return (T) this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @SuppressWarnings("unchecked")
    public T setCreateDate(Date createDate) {
        this.createDate = createDate;
        return (T) this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    @SuppressWarnings("unchecked")
    public T setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return (T) this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @SuppressWarnings("unchecked")
    public T setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return (T) this;
    }

    public String getRemark() {
        return remark;
    }

    @SuppressWarnings("unchecked")
    public T setRemark(String remark) {
        this.remark = remark;
        return (T) this;
    }

}
