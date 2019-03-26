package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Service
public class FileService extends BaseService<File, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileRepository fileRepository;

    @Override
    protected MongoRepository<File, String> getRepository() {
        return this.fileRepository;
    }


}
