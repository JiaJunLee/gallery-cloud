package com.oocl.ita.gallery.image.service.image;

import com.oocl.ita.gallery.common.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ImageRepository extends PagingAndSortingRepository<Image, String> {

    Page<Image> findAllByTagsLike(List<String> tags, Pageable pageable);
}
