package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.ImageFile;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "GALLERY-FILE-SERVICE", fallbackFactory = FileServiceClientFallbackFactory.class)
public interface FileServiceClient {
    @RequestMapping(value = "/files/{file_id}", method = RequestMethod.GET)
    ImageFile findById(@PathVariable("file_id") String id);
}
