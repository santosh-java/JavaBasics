package com.practice.rest.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Produces({ MediaType.TEXT_PLAIN })
@Consumes({ MediaType.TEXT_PLAIN })
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@HeaderParam("header1") String header1,
			@MatrixParam("mparam1") String mParam) {
		return "Header Param:" + header1 + " Matrix param: " + mParam;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		return "URIInfo->AbsolutePath: " + uriInfo.getAbsolutePath();
	}

}
