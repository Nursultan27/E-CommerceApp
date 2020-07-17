package ru.javamentor.ecommerce.dao.abstracts.modelDao;

import ru.javamentor.ecommerce.models.entities.VerificationToken;

public interface VerificationTokenDao extends ReadWriteDao<VerificationToken, Long>{

    VerificationToken findByUsername(String username);

    boolean existsByUsername(String username);;
}
