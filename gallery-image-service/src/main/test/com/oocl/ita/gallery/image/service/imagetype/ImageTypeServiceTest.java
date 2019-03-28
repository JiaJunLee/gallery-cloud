package com.oocl.ita.gallery.image.service.imagetype;

import com.oocl.ita.gallery.common.model.ImageType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.PagingAndSortingRepository;


public class ImageTypeServiceTest {

    @InjectMocks
    private ImageTypeService imageTypeService = new ImageTypeService();

    @Mock
    private ImageTypeRepository imageTypeRepository;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        Mockito.when(imageTypeRepository.findByTypeName(Mockito.eq("a"))).thenReturn(new ImageType());
    }

    @Test
    public void should_return_imageTypeRepository_when_getRepository() {
        //When
        PagingAndSortingRepository<ImageType, String> repository = imageTypeService.getRepository();

        //Then
        Assert.assertNotNull(repository);
    }

    @Test
    public void should_return_imageType_not_null_when_findByTypeName_given_name_a() {
        //When
        ImageType type = imageTypeService.findByTypeName("a");

        //Then
        Assert.assertNotNull(type);
    }
}