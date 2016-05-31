package com.example;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Template;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */
public abstract class DirectoryFinderWrapper<T extends ServerResource> extends InitFinderWrapper<T> implements DirectoryUri {

    @Override
    public ServerResource find(Request request, Response response) {
        T serverResource = createResource();
        Template url = getUrl();
        init(serverResource, request, response);
        return serverResource;
    }

}
