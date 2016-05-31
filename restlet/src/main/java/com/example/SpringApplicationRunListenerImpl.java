package com.example;

import org.restlet.ext.spring.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */
public class SpringApplicationRunListenerImpl implements SpringApplicationRunListener {
    @Autowired
    private SpringComponent restlet;
    public SpringApplicationRunListenerImpl(){

    }
    @Override
    public void started() {

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        try {
            restlet.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
