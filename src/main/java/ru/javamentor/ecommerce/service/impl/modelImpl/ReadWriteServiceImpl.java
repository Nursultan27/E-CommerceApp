package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.ReadWriteDao;
import ru.javamentor.ecommerce.service.abstracts.modelService.ReadWriteService;

import java.util.List;

@Service
public abstract class ReadWriteServiceImpl<T, PK> implements ReadWriteService<T, PK> {
    private final ReadWriteDao<T, PK> readWriteDao;

    @Autowired
    public ReadWriteServiceImpl(ReadWriteDao<T, PK> readWriteDao) {
        this.readWriteDao = readWriteDao;
    }

    @Override
    @Transactional
    public void persist(T t) {
        readWriteDao.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        readWriteDao.update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        readWriteDao.delete(t);
    }

    @Override
    public boolean existsById(PK id) {
        return readWriteDao.existsById(id);
    }

    @Override
    public T getByKey(PK id) {
        return readWriteDao.getByKey(id);
    }

    @Override
    public List<T> getAll() {
        return readWriteDao.getAll();
    }
}
