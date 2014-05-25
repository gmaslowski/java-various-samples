package com.gmaslowski.sample.repo;

import com.gmaslowski.sample.entity.BaseEntity;

import java.io.Serializable;

public interface GenericBaseEntityRepository<T extends BaseEntity> {

    T getById(Serializable entityId);

    void update(T entity);

    void save(T entity);

    void delete(Serializable entityId);

    void delete(T entity);

    boolean exists(Long entityId);
}