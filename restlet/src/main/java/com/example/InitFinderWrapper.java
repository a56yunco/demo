package com.example;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */
public abstract class InitFinderWrapper<T extends ServerResource> extends Finder implements InitFinder<T> {

    @Override
    public ServerResource find(Request request, Response response) {
        T serverResource = createResource();
        init(serverResource, request, response);
        return serverResource;
    }

    @Override
    @Lookup
    public final T createResource() {
        return null;
    }
}
