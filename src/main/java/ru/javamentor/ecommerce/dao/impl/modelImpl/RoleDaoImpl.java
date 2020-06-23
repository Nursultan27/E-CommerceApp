package ru.javamentor.ecommerce.dao.impl.modelImpl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.RoleDao;
import ru.javamentor.ecommerce.models.entities.Role;

@Repository
public class RoleDaoImpl extends ReadWriteDaoImpl<Role, Long> implements RoleDao {
}
