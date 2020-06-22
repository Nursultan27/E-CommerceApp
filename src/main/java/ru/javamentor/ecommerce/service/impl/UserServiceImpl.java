package ru.javamentor.ecommerce.service.impl;

import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.dao.abstracts.UserDao;
import ru.javamentor.ecommerce.models.entities.User;
import ru.javamentor.ecommerce.service.abstracts.UserService;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }
}
