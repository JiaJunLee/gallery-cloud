package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    ResponseEntity<ImageFile> save(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<ImageFile>(fileService.save(constructFile(file)), HttpStatus.CREATED);
    }

    private ImageFile constructFile(MultipartFile file) throws IOException {
        return new ImageFile(System.currentTimeMillis() + file.getOriginalFilename(),
                file.getContentType(),
                Long.toString(file.getSize()),
                Base64Utils.encodeToString(file.getBytes())
        );
    }

}
