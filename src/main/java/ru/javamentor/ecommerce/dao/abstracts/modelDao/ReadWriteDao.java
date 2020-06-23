package ru.javamentor.ecommerce.dao.abstracts.modelDao;

import java.util.List;

public interface ReadWriteDao<T, PK> {
    void persist(T t);

    void update(T t);

    void delete(T t);

    boolean existsById(PK id);

    T getByKey(PK id);

    List<T> getAll();
}
