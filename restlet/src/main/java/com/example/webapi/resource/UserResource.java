package com.example.webapi.resource;

import com.example.webapi.resource.server.Mail;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientProxy;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface UserResource extends ClientProxy{

    @Put
    void store(Representation representation) throws Exception;

    @Delete
    void remove() throws Exception;

    @Get
    Mail represent() throws Exception;

}

