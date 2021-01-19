package poo.lucas.domain.usecases.utils;

import java.util.List;
import java.util.Optional;

public interface DAO <T, K>{
    K create(T type);

    boolean update(T type);

    List<T> findAll();

    Optional <T> findOne(K key);

    boolean delete(T type);
}
