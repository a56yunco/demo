package com.example.webapi.resource.server;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.WriterRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.io.IOException;
import java.io.Writer;

/**
 * @author yangqidao on 16/5/30.
 * @version restlet
 */
public class DynamicContentServerResource extends ServerResource {
    @Get
    public Representation getDynamicContent() {
        Representation result = new WriterRepresentation(
                MediaType.TEXT_PLAIN) {
            @Override
            public void write(Writer writer) throws IOException {
                for (int i = 0; i < 10000; i++) {
                    writer.append("0123456789\n");
                }
            }
        };
        return result;
    }
}
