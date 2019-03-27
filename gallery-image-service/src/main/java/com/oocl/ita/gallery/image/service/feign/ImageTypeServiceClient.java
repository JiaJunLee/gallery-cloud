package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.ImageType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "GALLERY-FILE-TYPE-SERVICE", fallbackFactory = ImageTypeServiceClientFallbackFactory.class)
public interface ImageTypeServiceClient {
    @RequestMapping(value = "/image-types/{typeName}", method = RequestMethod.GET)
    ImageType findByTypeName(@PathVariable("typeName") String typeName);
}
