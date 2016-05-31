package com.example;

import org.restlet.ext.spring.SpringComponent;
import org.restlet.ext.spring.SpringRouter;
import org.restlet.ext.spring.SpringServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangqidao on 16/5/26.
 * @version restlet
 */
@Configuration
public class RestletConfig {
    @Autowired
    DemoSpringFinder demoSpringFinder;

    @Bean
    public SpringRouter root(){
        SpringRouter springRouter = new SpringRouter();
        springRouter.attach("/user", demoSpringFinder);
        return springRouter;
    }
    @Bean
    public SpringRouter defaultRouter(){
        SpringRouter springRouter = new SpringRouter();
        springRouter.attach("/v1", root());
        return springRouter;
    }
    @Bean
    public SpringServer server(){
        SpringServer springServer = new SpringServer("http", 9003);
        return springServer;
    }

    @Bean
    public SpringComponent component(){
        SpringComponent springComponent = new SpringComponent();
        springComponent.setServer(server());
        springComponent.getInternalRouter().attach("/internal", new InternalApplication());
        springComponent.setDefaultTarget(defaultRouter());
        springComponent.getDefaultHost().attach("/v2", new RestletApplication());
        return springComponent;
    }
}
