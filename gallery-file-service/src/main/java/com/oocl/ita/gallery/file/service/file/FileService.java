package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Service
public class FileService extends BaseService<ImageFile, String> {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public PagingAndSortingRepository<ImageFile, String> getRepository() {
        return this.fileRepository;
    }

    public ImageFile saveFile(MultipartFile file) throws IOException {
        return this.save(constructFile(file));
    }

    private ImageFile constructFile(MultipartFile file) throws IOException {
        return new ImageFile(System.currentTimeMillis() + file.getOriginalFilename(),
                file.getContentType(),
                Long.toString(file.getSize()),
                Base64Utils.encodeToString(file.getBytes())
        );
    }
}
