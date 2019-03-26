package com.oocl.ita.gallery.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * Created by Justin Liu on 3/20/2019.
 */
public class BaseDocument {
    @Id
    String id;

    @CreatedDate
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    Date createdDate;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    Date lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
