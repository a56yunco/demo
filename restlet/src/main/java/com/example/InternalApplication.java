package com.example;

import com.example.webapi.resource.server.DynamicContentServerResource;
import org.restlet.Restlet;
import org.restlet.ext.swagger.SwaggerApplication;
import org.restlet.resource.Directory;
import org.restlet.routing.Extractor;
import org.restlet.routing.Redirector;
import org.restlet.routing.Router;

/**
 * @author yangqidao on 16/5/27.
 * @version restlet
 */
public class InternalApplication extends SwaggerApplication {
    public Router createApiRouter() {
    Router apiRouter = new Router(getContext());
    // apiRouter.attach(ROUTE_USER, UserServerResource.class);

    //ChallengeAuthenticator guard = new ChallengeAuthenticator(getContext(), ChallengeScheme.CUSTOM, "aa");
    //apiRouter.attach("/*", guard);
    return apiRouter;
}

    public InternalApplication() {
    }

    @Override
    public Restlet createInboundRoot() {
        // Router for the API's resources
        // Protect the set of resources
        //ChallengeAuthenticator guard = createApiRouter(apiRouter);
        Router router = new Router(getContext());
        String rootUri = "file:///"
                + System.getProperty("user.home");
        Directory directory = new Directory(getContext(), rootUri);
        directory.setListingAllowed(true);
        router.attach("/home", directory);

        String target
                = "http://www.google.com/search?q=site:mysite.org+{keywords}";
        Redirector redirector = new Redirector(getContext(), target,
                Redirector.MODE_CLIENT_TEMPORARY);
        Extractor extractor = new Extractor(getContext(), redirector);
        extractor.extractFromQuery("keywords", "kwd", true);
        router.attach("/search", extractor);

        router.attach("/dynamic", DynamicContentServerResource.class);
        return router;
    }
}
