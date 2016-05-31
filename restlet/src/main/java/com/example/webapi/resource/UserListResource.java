package com.example.webapi.resource;

import com.example.webapi.representation.User;
import org.restlet.resource.Post;

public interface UserListResource {

    @Post
    void add(User bean) throws Exception;

}

