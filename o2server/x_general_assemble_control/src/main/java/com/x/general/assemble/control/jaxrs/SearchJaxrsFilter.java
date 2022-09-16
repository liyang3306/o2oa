package com.x.general.assemble.control.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.project.jaxrs.CipherManagerUserJaxrsFilter;

@WebFilter(urlPatterns = "/jaxrs/search/*", asyncSupported = true)
public class SearchJaxrsFilter extends CipherManagerUserJaxrsFilter {

}
