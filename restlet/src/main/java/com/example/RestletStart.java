package com.example;

import org.restlet.ext.spring.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */

@SpringBootApplication
public class RestletStart extends SpringApplication implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private SpringComponent restlet;

    public RestletStart(){
        super();
    }
    public RestletStart(Object... sources) {
        super(sources);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(event);
        try {
            restlet.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
