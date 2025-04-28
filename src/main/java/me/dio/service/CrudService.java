package me.dio.service;

import java.util.List;

public interface CrudService<ID, T> {
    List<T> findaAll();
    T findById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
