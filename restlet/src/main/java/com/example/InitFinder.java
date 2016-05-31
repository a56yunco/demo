package com.example;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.ServerResource;

/**
 * @author yangqidao on 16/5/31.
 * @version restlet
 */
public interface InitFinder<T extends ServerResource> {
    public boolean exist(Request request);
    public T createResource();
    public void init(T resource, Request request, Response response);
}
