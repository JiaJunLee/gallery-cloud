package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.ImageFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;

import static org.powermock.api.support.membermodification.MemberModifier.suppress;


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
        suppress(MemberMatcher.methodsDeclaredIn(BaseService.class));
        MultipartFile file = new MockMultipartFile("pic","pic".getBytes());

        //When
        ImageFile imageFile = fileService.saveFile(file);

        //Then
        Assert.assertNull(imageFile);
    }
}