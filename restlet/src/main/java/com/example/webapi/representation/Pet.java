package com.example.webapi.representation;

import java.util.ArrayList;

public class Pet {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private java.util.List<String> photoUrls;



    public java.util.List<String> getPhotoUrls() {
        if (photoUrls == null) {
            photoUrls = new ArrayList<String>();
        }
        return photoUrls;
    }

    public void setPhotoUrls(java.util.List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }


    private java.util.List<String> tags;



    public java.util.List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        return tags;
    }

    public void setTags(java.util.List<String> tags) {
        this.tags = tags;
    }


    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
