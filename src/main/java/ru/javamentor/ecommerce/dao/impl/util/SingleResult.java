package ru.javamentor.ecommerce.dao.impl.util;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class SingleResult {

    public static <T> Optional<T> getSingleResultOrNull(TypedQuery<T> var) {
        try {
            return Optional.of(var.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
