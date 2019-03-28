package com.oocl.ita.gallery.file.service.file;

import com.oocl.ita.gallery.common.log.annotation.LogRuntimeLogger;
import com.oocl.ita.gallery.common.log.annotation.LogTag;
import com.oocl.ita.gallery.common.model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Controller
@RequestMapping
@LogRuntimeLogger(topic = "GALLERY-FILE-TOPIC")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    @LogTag("FILE-SAVE")
    ResponseEntity<ImageFile> save(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<ImageFile>(fileService.saveFile(file), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{file_id}", method = RequestMethod.GET)
    @LogTag("FILE-FIND-BY-ID")
    ResponseEntity<ImageFile> findById(@PathVariable("file_id") String id) {
        return new ResponseEntity<ImageFile>(fileService.findById(id), HttpStatus.OK);
    }

}
