package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.UserDao;
import ru.javamentor.ecommerce.dao.impl.util.SingleResult;
import ru.javamentor.ecommerce.models.entities.User;

import java.util.Optional;

@Repository
public class UserDaoImpl extends ReadWriteDaoImpl<User, Long> implements UserDao {

    @Override
    public Optional<User> findUserByEmail(String email) {
        return SingleResult.getSingleResult(entityManager.createQuery("SELECT u FROM User u WHERE u.email = :e", User.class)
                .setParameter("e", email));
    }
}
