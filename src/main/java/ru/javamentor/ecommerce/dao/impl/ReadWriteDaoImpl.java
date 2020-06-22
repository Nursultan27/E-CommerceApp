package ru.javamentor.ecommerce.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.ecommerce.dao.abstracts.ReadWriteDao;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class ReadWriteDaoImpl<T, PK> implements ReadWriteDao<T, PK> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager; // all classes which extends this class, will have an access

    @SuppressWarnings("unchecked")
    public ReadWriteDaoImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];

        // getting the generic of superclass
        // multiple Qualifer
    }

    @Override
    @Transactional
    public void persist(T t) {
        entityManager.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        entityManager.remove(t);
    }

    @Override
    public boolean existsById(PK id) {
        return entityManager.find(clazz, id) != null;
    }

    @Override
    public T getByKey(PK id) {
        return entityManager.find(clazz, id);
    }

        @Override
    public List<T> getAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }
}
