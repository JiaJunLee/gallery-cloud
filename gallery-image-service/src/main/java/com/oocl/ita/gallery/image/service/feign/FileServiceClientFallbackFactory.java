package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.ImageFile;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FileServiceClientFallbackFactory implements FallbackFactory<FileServiceClient> {
    @Override
    public FileServiceClient create(Throwable throwable) {
        return new FileServiceClient() {
            @Override
            public ImageFile findById(String id) {
                return null;
            }
        };
    }
}
