package ru.javamentor.ecommerce.service.abstracts.modelService;

import java.util.List;

public interface ReadWriteService<T, PK> {
    void persist(T t);

    void update(T t);

    void delete(T t);

    boolean existsById(PK id);

    T getByKey(PK id);

    List<T> getAll();
}
