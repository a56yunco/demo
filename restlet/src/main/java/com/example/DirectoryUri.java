package com.example;

import org.restlet.routing.Template;

/**
 * @author yangqidao on 16/5/31.
 * @version restlet
 */
public interface DirectoryUri {
    public DirectoryUri getParent();
    public Template getUrl();
}
