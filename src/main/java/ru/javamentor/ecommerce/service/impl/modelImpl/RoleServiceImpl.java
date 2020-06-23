package ru.javamentor.ecommerce.service.impl.modelImpl;

import org.springframework.stereotype.Service;
import ru.javamentor.ecommerce.dao.abstracts.modelDao.RoleDao;
import ru.javamentor.ecommerce.models.entities.Role;
import ru.javamentor.ecommerce.service.abstracts.modelService.RoleService;

@Service
public class RoleServiceImpl extends ReadWriteServiceImpl<Role, Long> implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }
}
