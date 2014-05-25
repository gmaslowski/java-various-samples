package com.gmaslowski.sample.repo;

import com.gmaslowski.sample.entity.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractBaseEntityJpaRepository<T extends BaseEntity> implements GenericBaseEntityRepository<T> {

    protected EntityManager em;
    protected Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractBaseEntityJpaRepository() {
        this.persistentClass = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T getById(Serializable entityId) {
        return em.find(persistentClass, entityId);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Serializable entityId) {
        em.remove(em.find(persistentClass, entityId));
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public boolean exists(Long entityId) {
        return em.find(persistentClass, entityId) != null;
    }

    protected abstract void setEntityManager(EntityManager em);
}