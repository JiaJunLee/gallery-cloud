package com.oocl.ita.gallery.common.model;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseService<T extends BaseDocument, ID extends Serializable> {

    public abstract PagingAndSortingRepository<T, ID> getRepository();

    boolean isExists(ID id) {
        return getRepository().exists(id);
    }

    T findById(ID id) {
        return getRepository().findOne(id);
    }

    public T save(T t) {
        t.setLastModifiedDate(new Date());
        return getRepository().save(t);
    }

    public Iterable<T> saveAll(Iterable<T> ts) {
        return getRepository().save(ts);
    }

    public boolean deleteById(ID id) {
        try {
            getRepository().delete(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    boolean deleteAll(Iterable<T> ts) {
        try {
            getRepository().delete(ts);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

}