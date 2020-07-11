package ru.javamentor.ecommerce.dao.abstracts.modelDao;

import ru.javamentor.ecommerce.models.entities.User;

import java.util.Optional;

public interface UserDao extends ReadWriteDao<User, Long> {
    Optional<User> findUserByEmail(String email);
}
