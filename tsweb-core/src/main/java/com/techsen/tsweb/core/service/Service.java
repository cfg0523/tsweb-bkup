package com.techsen.tsweb.core.service;

import com.techsen.tsweb.core.domain.BaseEntity;

public interface Service<T extends BaseEntity<T>> {

    public T addEntity(T entity);
    
    public void deleteEntity(T entity);
    
    public void updateEntity(T entity);
    
    public T getEntity(T entity);
    
    public T getById(String entityId);
    
}
