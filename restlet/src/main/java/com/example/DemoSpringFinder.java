package com.example;

import com.example.webapi.resource.server.UserServerResource;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.ext.spring.SpringFinder;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */
@Component
public class DemoSpringFinder<T extends ServerResource> extends SpringFinder {

    @Override
    public ServerResource find(Request request, Response response) {
        ServerResource serverResource = super.find(request, response);

        return serverResource;
    }

    @Override
    @Lookup(value = "userServerResource")
    public ServerResource create() {
        return super.create();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public UserServerResource userServerResource(){
        UserServerResource userServerResource = new UserServerResource();
        return userServerResource;
    }
}
