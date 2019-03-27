package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.ImageType;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ImageTypeServiceClientFallbackFactory implements FallbackFactory<ImageTypeServiceClient> {
    @Override
    public ImageTypeServiceClient create(Throwable throwable) {
        return new ImageTypeServiceClient() {
            @Override
            public ImageType findByTypeName(String typeName) {
                return null;
            }
        };
    }
}
