package com.oocl.ita.gallery.file.service.file;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Repository
public interface FileRepository extends MongoRepository<File, String>{
}
