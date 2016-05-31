package com.example;

import com.example.webapi.resource.server.UserServerResource;
import org.restlet.Request;
import org.restlet.Response;

/**
 * @author yangqidao on 16/5/31.
 * @version restlet
 */
public class InitFinderWrapperImpl extends InitFinderWrapper<UserServerResource> {

    @Override
    public boolean exist(Request request) {
        return false;
    }

    @Override
    public void init(UserServerResource resource, Request request, Response response) {
        Object accountId = request.getAttributes().get("accountId");
        if (accountId instanceof Integer) {
            resource.setAccountId((Integer)accountId);
        }
    }
}
