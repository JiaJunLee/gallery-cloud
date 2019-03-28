package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.model.ImageFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;


public class FileServiceTest {

    @InjectMocks
    private FileService fileService = new FileService();

    @Mock
    private FileRepository fileRepository;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_fileRepository_when_getRepository() {
        //When
        PagingAndSortingRepository<ImageFile, String> repository = fileService.getRepository();

        //Then
        Assert.assertNotNull(repository);
    }

    @Test
    public void should_return_null_when_saveFile_given_mockFile() throws IOException {
        //Given
        MultipartFile file = new MockMultipartFile("pic","pic".getBytes());

        //When
        ImageFile imageFile = fileService.saveFile(file);

        //Then
        Assert.assertNull(imageFile);
    }
}