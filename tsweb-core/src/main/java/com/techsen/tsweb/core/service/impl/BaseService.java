package com.techsen.tsweb.core.service.impl;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.service.Service;

public abstract class BaseService<E extends BaseEntity<E>, T extends Dao<E>>
        implements Service<E> {

    protected T dao;
    
    public abstract void setDao(T dao);

    @Override
    public E addEntity(E entity) {
        this.dao.addEntity(entity);
        return entity;
    }

    @Override
    public void deleteEntity(E entity) {
        this.dao.deleteEntity(entity);
    }

    @Override
    public void updateEntity(E entity) {
        this.dao.updateEntity(entity);
    }

    @Override
    public E getEntity(E entity) {
        return this.dao.getEntity(entity);
    }

    @Override
    public E getById(String entityId) {
        return this.dao.getById(entityId);
    }

}
