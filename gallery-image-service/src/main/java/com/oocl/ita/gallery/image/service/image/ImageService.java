package com.oocl.ita.gallery.image.service.image;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService extends BaseService<Image, String> {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public PagingAndSortingRepository<Image, String> getRepository() {
        return this.imageRepository;
    }

    Page<Image> findAllByTagsLike(List<String> tags, Pageable pageable) {
        return this.imageRepository.findAllByTagsLike(tags, pageable);
    }
}
