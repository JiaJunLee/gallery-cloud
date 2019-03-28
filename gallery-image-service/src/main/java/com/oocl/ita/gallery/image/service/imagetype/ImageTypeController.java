package com.oocl.ita.gallery.image.service.imagetype;

import com.oocl.ita.gallery.common.model.ImageType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/types")
public class ImageTypeController {

    @Autowired
    ImageTypeService imageTypeService;

    @PostMapping
    public ResponseEntity<ImageType> save(@RequestBody ImageType imageType) {
        return new ResponseEntity<ImageType>(imageTypeService.save(imageType), HttpStatus.CREATED);
    }

    @DeleteMapping("/{delete_Id}")
    ResponseEntity<ImageType> deleteById(@PathVariable("delete_Id") String imageId) {
        ImageType imageType = imageTypeService.findById(imageId);
        if (imageType == null) {
            return new ResponseEntity<ImageType>(HttpStatus.NOT_FOUND);
        }
        imageTypeService.deleteById(imageId);
        return new ResponseEntity<ImageType>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<ImageType> update(@RequestBody ImageType imageType) {
        if (!imageTypeService.isExists((imageType == null ? null : imageType.getId()))) {
            return new ResponseEntity<ImageType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ImageType>(imageTypeService.save(imageType), HttpStatus.RESET_CONTENT);
    }

    @GetMapping("/{image_id}")
    ResponseEntity<ImageType> get(@PathVariable("image_id") String imageId) {
        ImageType imageType = imageTypeService.findById(imageId);
        if (imageType == null) {
            return new ResponseEntity<ImageType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ImageType>(imageType, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<ImageType>> getAll() {
        return new ResponseEntity<List<ImageType>>((List<ImageType>) imageTypeService.findAll(), HttpStatus.OK);
    }

}
