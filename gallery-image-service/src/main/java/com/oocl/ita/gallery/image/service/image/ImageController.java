package com.oocl.ita.gallery.image.service.image;

import com.oocl.ita.gallery.common.model.Image;
import com.oocl.ita.gallery.common.model.ImageFile;
import com.oocl.ita.gallery.common.model.ImageType;
import com.oocl.ita.gallery.common.model.User;
import com.oocl.ita.gallery.image.service.feign.FileServiceClient;
import com.oocl.ita.gallery.image.service.feign.ImageTypeServiceClient;
import com.oocl.ita.gallery.image.service.feign.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private FileServiceClient fileServiceClient;
    @Autowired
    private ImageTypeServiceClient imageTypeServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping
    public ResponseEntity<User> test() {
        return this.userServiceClient.getUserEntity();
    }


    @GetMapping("/{image_id}")
    public ResponseEntity<Image> get(@PathVariable("image_id") String imageId) {
        Image image = imageService.findById(imageId);
        if (image == null) {
            return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Image>(image, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Map> get(@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex, @RequestParam(value = "pageSize", defaultValue = "30") int pageSize, String tags) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Image> imagePage;
        if (!StringUtils.isEmpty(tags)) {
            imagePage = imageService.findAllByTagsLike(Arrays.asList(tags.split(" ")), pageable);
        } else {
            imagePage = imageService.findAll(pageable);
        }

        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(3);
        map.put("images", imagePage.getContent());
        map.put("total", imagePage.getTotalElements());
        map.put("currentPageIndex", imagePage.getNumber());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> save(@RequestBody Image image) {
        if (image != null && image.getImageFile() != null && !StringUtils.isEmpty(image.getImageFile().getId())) {
            ImageFile imageFile = fileServiceClient.findById(image.getImageFile().getId());
            BufferedImage bufferedImage = null;
            try {
                if (!StringUtils.isEmpty(imageFile.getFileContent())) {
                    bufferedImage = ImageIO.read(new BufferedInputStream(new ByteArrayInputStream(Base64Utils.decodeFromString(imageFile.getFileContent()))));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (bufferedImage == null) {
                throw new RuntimeException("no image！");
            }
            image.setImageWidth(bufferedImage.getWidth());
            image.setImageHeight(bufferedImage.getHeight());
        }
        if (image != null && image.getImageType() != null && !StringUtils.isEmpty(image.getImageType().getTypeName())) {
            image.setImageType(imageTypeServiceClient.findByTypeName(image.getImageType().getTypeName()));
        }
        return new ResponseEntity<Image>(imageService.save(image), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Image> update(@RequestBody Image image) {
        if (!imageService.isExists((image == null ? null : image.getId()))) {
            return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
        }
        if (image != null && image.getImageType() != null && !StringUtils.isEmpty(image.getImageType().getTypeName())) {
            image.setImageType(imageTypeServiceClient.findByTypeName(image.getImageType().getTypeName()));
        }
        return new ResponseEntity<Image>(imageService.save(image), HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/{image_id}")
    public ResponseEntity<Image> delete(@PathVariable("image_id") String imageId) {
        Image image = imageService.findById(imageId);
        if (image == null) {
            return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
        }

        imageService.deleteById(imageId);
        return new ResponseEntity<Image>(HttpStatus.NO_CONTENT);
    }

}
