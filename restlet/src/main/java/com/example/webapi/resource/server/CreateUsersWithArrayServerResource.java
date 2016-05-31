package com.example.webapi.resource.server;

import com.example.webapi.representation.User;
import com.example.webapi.resource.CreateUsersWithArrayResource;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import java.util.logging.Level;

public class CreateUsersWithArrayServerResource extends AbstractServerResource implements CreateUsersWithArrayResource {

    // Define allowed roles for the method "post".
    private static final String[] post12AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post12DeniedGroups = new String[] {};

    @Override
    protected Representation get(Variant variant) throws ResourceException {
        return super.get(variant);
    }

    @Override
    public void add(User bean) throws Exception {
        checkGroups(post12AllowedGroups, post12DeniedGroups);
        
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

