package com.example.webapi.resource.server;

import com.example.webapi.representation.User;
import com.example.webapi.resource.UserListResource;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.springframework.context.annotation.Scope;

import java.util.logging.Level;

@Scope("prototype")
public class UserListServerResource extends AbstractServerResource implements UserListResource {

    // Define allowed roles for the method "post".
    private static final String[] post11AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post11DeniedGroups = new String[] {};

    public void add(User bean) throws Exception {
        checkGroups(post11AllowedGroups, post11DeniedGroups);
        
    	if (bean==null) {
    		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
    	}

        try {
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        
    }


}

