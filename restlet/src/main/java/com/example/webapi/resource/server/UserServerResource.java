package com.example.webapi.resource.server;

import com.example.webapi.DemoService;
import com.example.webapi.resource.UserResource;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
@Getter
@Setter
public class UserServerResource extends ServerResource implements UserResource {
    private static int number = 0;
    private Long companyId;
    private int accountId;
    @Autowired
    private DemoService demoService;

    public UserServerResource() {
        number += 1;
    }

    @Override
    protected void doInit() throws ResourceException {
        getVariants().add(new Variant(MediaType.APPLICATION_XML));
        getVariants().add(new Variant(MediaType.APPLICATION_JSON));

        String accountIdAttribute = getAttribute("accountId");
        if (accountIdAttribute != null) {
            this.accountId = Integer.parseInt(accountIdAttribute);
            setName("Resource for mail account ‘" + this.accountId + "’");
            setDescription("The resource describing mail account "
                    + "number ‘" + this.accountId + "’");
        } else {
            setName("Mail account resource");
            setDescription("The resource describing a mail account");
        }
    }

//    @Override
//    protected void describe(ApplicationInfo applicationInfo) {
//        super.describe(applicationInfo);
//        RepresentationInfo rep =
//                new RepresentationInfo(MediaType.TEXT_PLAIN);
//        rep.setIdentifier("account");
//        applicationInfo.getRepresentations().add(rep);
//        DocumentationInfo doc = new DocumentationInfo();
//        doc.setTitle("Account");
//        doc.setTextContent("Simple string containing the account ID");
//        rep.getDocumentations().add(doc);
//    }


    @Override
    protected Representation get(Variant variant) throws ResourceException {
        String accountId = getAttribute("accountId");
        String mailId = getAttribute("mailId");
        String mailApiUri = "riap://component/internal/accounts/" + accountId + "/mails/"
                + mailId;
        ClientResource cr = new ClientResource(mailApiUri);
        Representation result = null;
        Mail mail = new Mail();
        mail.setStatus("received");
        mail.setAccountRef(new Reference(getReference(), "..").getTargetRef()
                .toString());
        if (MediaType.APPLICATION_XML.isCompatible(variant.getMediaType())) {
            result = new JacksonRepresentation<Mail>(mail);
        } else if (MediaType.APPLICATION_JSON.isCompatible(variant
                .getMediaType())) {
            result = new JacksonRepresentation<Mail>(mail);
        }
        return result;
    }

    @Override
    public void store(Representation representation) throws Exception {

        JacksonRepresentation<Mail> mailRep = new JacksonRepresentation<>(
                representation, Mail.class);
        Mail mail = mailRep.getObject();
        System.out.println("Status: " + mail.getStatus());
        System.out.println("Account URI: " + mail.getAccountRef());
        RestletFileUpload fileUpload = new RestletFileUpload(new DiskFileItemFactory());
        FileItemIterator iterator = fileUpload.getItemIterator(representation);
        while (iterator.hasNext()){
            FileItemStream next = iterator.next();
            System.out.println(next.openStream());
        }

    }

    @Override
    public void remove() throws Exception {

    }

    @Override
    public Mail represent() throws Exception {
        Mail mail = new Mail();
        mail.setStatus("received");
        mail.setAccountRef(new Reference(getReference(), "..").getTargetRef()
                .toString());
        return mail;
//        return new JacksonRepresentation<>(mail);
//        JSONObject mailElt = new JSONObject();
//        JSONObject jsonObject = new JSONObject();
//        mailElt.put("sss", jsonObject);
//        mailElt.put("status", "received");
//        mailElt.put("subject", "Message to self");
//        mailElt.put("content", "Doh!");
//        mailElt.put("accountRef", new Reference(getReference(), "..")
//                .getTargetRef().toString());
//        return new JsonRepresentation(mailElt);
//        return demoService.print() + number;
    }

    @Override
    public ClientResource getClientResource() {
        return null;
    }
//
//    @Override
//    protected void describeGet(MethodInfo info) {
//        super.describeGet(info);
//    }

    //    // Define allowed roles for the method "put".
//    private static final String[] put14AllowedGroups = new String[] {"anyone"};
//    // Define denied roles for the method "put".
//    private static final String[] put14DeniedGroups = new String[] {};
//
//    public void store(User bean) throws Exception {
//        checkGroups(put14AllowedGroups, put14DeniedGroups);
//
//    	if (bean==null) {
//    		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
//    	}
//
//        try {
//         } catch (Exception ex) {
//            // In a real code, customize handling for each type of exception
//            getLogger().log(Level.WARNING, "Error when executing the method", ex);
//            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
//                    ex.getMessage(), ex);
//        }
//
//
//    }
//
//    // Define allowed roles for the method "delete".
//    private static final String[] delete15AllowedGroups = new String[] {"anyone"};
//    // Define denied roles for the method "delete".
//    private static final String[] delete15DeniedGroups = new String[] {};
//
//    public void remove() throws Exception {
//        checkGroups(delete15AllowedGroups, delete15DeniedGroups);
//
//
//        try {
//         } catch (Exception ex) {
//            // In a real code, customize handling for each type of exception
//            getLogger().log(Level.WARNING, "Error when executing the method", ex);
//            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
//                    ex.getMessage(), ex);
//        }
//
//
//    }
//
//    // Define allowed roles for the method "get".
//    private static final String[] get16AllowedGroups = new String[] {"anyone"};
//    // Define denied roles for the method "get".
//    private static final String[] get16DeniedGroups = new String[] {};
//
//    public User represent() throws Exception {
//        User result = null;
//        checkGroups(get16AllowedGroups, get16DeniedGroups);
//
//
//        try {
//
//			// Path variables
//
//	    String userloginPathVariable = Reference.decode(getAttribute("userlogin"));
//
//        // Query parameters
//
//
//	    result = new User();
//
//	    // Initialize here your bean
//         } catch (Exception ex) {
//            // In a real code, customize handling for each type of exception
//            getLogger().log(Level.WARNING, "Error when executing the method", ex);
//            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
//                    ex.getMessage(), ex);
//        }
//
//        return result;
//    }


}

