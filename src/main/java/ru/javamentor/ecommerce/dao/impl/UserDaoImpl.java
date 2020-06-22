package ru.javamentor.ecommerce.dao.impl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.UserDao;
import ru.javamentor.ecommerce.models.entities.User;

@Repository
public class UserDaoImpl extends ReadWriteDaoImpl<User, Long> implements UserDao {
}
