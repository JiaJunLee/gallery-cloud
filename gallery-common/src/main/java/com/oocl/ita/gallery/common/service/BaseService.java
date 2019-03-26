package com.oocl.ita.gallery.common.service;

import com.oocl.ita.gallery.common.model.BaseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Justin Liu on 3/26/2019.
 */
public abstract class BaseService<T, ID extends Serializable> {

    protected abstract MongoRepository<T, ID> getRepository();

    public boolean isExists(ID id) {
        return getRepository().exists(id);
    }

    public T findById(ID id) {
        return getRepository().findOne(id);
    }

    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    public T save(T t) {
        if (t instanceof BaseDocument) {
            ((BaseDocument) t).setLastModifiedDate(new Date());
        }
        return getRepository().save(t);
    }

    public Iterable<T> saveAll(Iterable<T> ts) {
        return getRepository().save(ts);
    }

    public boolean delete(T t) {
        try {
            getRepository().delete(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteById(ID id) {
        try {
            getRepository().delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAll(List<ID> ids) {
        try {
            for (ID id : ids) {
                getRepository().delete(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
