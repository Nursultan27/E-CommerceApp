package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.VerificationTokenDao;
import ru.javamentor.ecommerce.models.entities.VerificationToken;

@Repository
public class VerificationTokenDaoImpl extends ReadWriteDaoImpl<VerificationToken, Long> implements VerificationTokenDao {

    @Override
    public VerificationToken findByUsername(String username) {

        try {
            return entityManager.createQuery("SELECT vt FROM VerificationToken vt WHERE vt.username = :u", VerificationToken.class)
                    .setParameter("u", username)
                    .getSingleResult();
        } catch (Exception e) { // No result found exception
            return null;
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        try {
            entityManager.createQuery("SELECT vt.username FROM VerificationToken vt WHERE vt.username = :u", String.class)
                    .setParameter("u", username)
                    .getSingleResult();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
