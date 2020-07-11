package ru.javamentor.ecommerce.dao.impl.dtoImpl;

import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import ru.javamentor.ecommerce.dao.impl.modelImpl.ReadWriteDaoImpl;
import ru.javamentor.ecommerce.dao.abstracts.dtoDao.UserDtoDao;
import ru.javamentor.ecommerce.models.dto.UserDto;

import java.util.List;

public class UserDtoDaoImpl extends ReadWriteDaoImpl<UserDto, Long> implements UserDtoDao {
    @Override
    public UserDto findUserByEmail(String email) {
        return (UserDto) entityManager.createQuery("SELECT " +
                "u.id, " +
                "u.email, " +
                "FROM User u WHERE u.email = :e", UserDto.class)
                .setParameter("e", email)
                .unwrap(Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] objects, String[] strings) {
                        return UserDto.builder()
                                .id((Long) objects[0])
                                .email((String) objects[1])
                                .build();
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                }).getSingleResult();
    }
}
