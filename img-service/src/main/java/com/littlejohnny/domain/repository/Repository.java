package com.littlejohnny.domain.repository;

import java.util.Optional;

public interface Repository<T, ID> {
    Optional<T> findById(ID id);

    <S extends T> S save(S entity);

    void deleteById(ID id);
}
