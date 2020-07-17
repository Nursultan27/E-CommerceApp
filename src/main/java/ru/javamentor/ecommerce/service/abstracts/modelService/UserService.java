package ru.javamentor.ecommerce.service.abstracts.modelService;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.ecommerce.models.entities.User;

public interface UserService extends ReadWriteService<User, Long>, UserDetailsService{
}
