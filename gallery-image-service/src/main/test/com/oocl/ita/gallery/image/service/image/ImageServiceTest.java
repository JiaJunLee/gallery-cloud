package com.oocl.ita.gallery.image.service.image;

import com.oocl.ita.gallery.common.model.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ImageServiceTest {

    @InjectMocks
    private ImageService imageService = new ImageService();

    @Mock
    private ImageRepository imageRepository;

    List<String> tags;

    @Before
    public void setUp() {
        tags = new ArrayList<>();
        tags.add("a");
        MockitoAnnotations.initMocks(this);
        List<Image> images = new ArrayList();
        images.add(new Image());
        Page<Image> page = new PageImpl<Image>(images);
        Mockito.when(imageRepository.findAllByTagsLike(Mockito.any(),Mockito.any())).thenReturn(page);
    }

    @Test
    public void should_return_imageRepository_when_getRepository() {
        //When
        PagingAndSortingRepository<Image, String> repository = imageService.getRepository();

        //Then
        Assert.assertNotNull(repository);
    }

    @Test
    public void should_return_page_size_1_when_findAllByTagsLike_given_tag_a() {
        //When
        Page<Image> allByTagsLike = imageService.findAllByTagsLike(tags, null);

        //Then
        Assert.assertNotNull(allByTagsLike);
        Assert.assertEquals(1,allByTagsLike.getContent().size());
    }
}