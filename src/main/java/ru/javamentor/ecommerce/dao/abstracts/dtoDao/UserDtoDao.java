package ru.javamentor.ecommerce.dao.abstracts.dtoDao;

import ru.javamentor.ecommerce.models.dto.UserDto;


public interface UserDtoDao {

    UserDto findUserByEmail(String email);
}
