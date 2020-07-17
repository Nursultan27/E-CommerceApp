package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.models.entities.User;
import ru.javamentor.ecommerce.service.abstracts.modelService.UserService;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User u = userDao.findUserByEmail(email);

        if (u != null) {
            return u;
        } else {
            throw new UsernameNotFoundException(String.format("Email %s doesn't exist", email));
        }
    }
}
