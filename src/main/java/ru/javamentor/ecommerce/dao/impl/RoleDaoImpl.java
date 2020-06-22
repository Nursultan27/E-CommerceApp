package ru.javamentor.ecommerce.dao.impl;

import org.springframework.stereotype.Repository;
import ru.javamentor.ecommerce.dao.abstracts.RoleDao;
import ru.javamentor.ecommerce.models.entities.Role;

@Repository
public class RoleDaoImpl extends ReadWriteDaoImpl<Role, Long> implements RoleDao {
}
