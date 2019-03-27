package com.oocl.ita.gallery.image.service.imagetype;

import com.oocl.ita.gallery.common.model.ImageType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ImageTypeRepository extends PagingAndSortingRepository<ImageType, String> {

  ImageType findByTypeName(String typeName);
}
