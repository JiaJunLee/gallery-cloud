package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.model.ImageFile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Repository
public interface FileRepository extends PagingAndSortingRepository<ImageFile, String> {
}
