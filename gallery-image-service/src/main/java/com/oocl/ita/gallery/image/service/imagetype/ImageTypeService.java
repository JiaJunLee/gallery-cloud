package com.oocl.ita.gallery.image.service.imagetype;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ImageTypeService extends BaseService<ImageType, String> {

  @Autowired
  ImageTypeRepository imageTypeRepository;

  @Override
  public PagingAndSortingRepository getRepository() {
    return this.imageTypeRepository;
  }

  ImageType findByTypeName(String typeName) {
    return this.imageTypeRepository.findByTypeName(typeName);
  }
}
