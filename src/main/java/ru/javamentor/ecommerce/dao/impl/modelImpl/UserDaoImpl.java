package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.models.entities.User;

@Repository
public class UserDaoImpl extends ReadWriteDaoImpl<User, Long> implements UserDao {

    @Override
    public User findUserByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :e", User.class)
                .setParameter("e", email)
                .getSingleResult();


//        return SingleResult.getSingleResult(entityManager.createQuery("SELECT u FROM User u WHERE u.email = :e", User.class)
//                .setParameter("e", email));
    }
}