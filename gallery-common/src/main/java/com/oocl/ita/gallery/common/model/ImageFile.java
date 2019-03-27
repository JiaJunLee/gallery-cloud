package com.oocl.ita.gallery.common.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Justin Liu on 3/26/2019.
 */
@Document(collection = "files")
public class ImageFile extends BaseDocument {

    public ImageFile(String fileName, String fileType, String fileSize, String fileContent) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.fileContent = fileContent;
    }

    @Field("file_name")
    String fileName;

    @Field("file_type")
    String fileType;

    @Field("file_size")
    String fileSize;

    @Field("file_content")
    String fileContent;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
}
