package org.girish.webservice.myWebService.messageResource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.girish.webservice.myWebService.beanParam.MyBeanParam;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnnotationDemo {
	
	@GET
	@Path("annotationsDemo")
	public String getValuesUsingAnnotations(@MatrixParam("matrixParam") String matrixParam, 
								 			@HeaderParam("headerParam") String headerParam,
								 			@CookieParam("cookieParam") String cookieParam){
		return "MatrixParam : " + matrixParam + ", " +
			   "HeaderParam : " + headerParam + ", " +
			   "CookieParam : " + cookieParam + ", ";
	}
	
	@GET
	@Path("contextDemo")
	public String getValuesUsingContextAnnotation(@Context UriInfo uriInfo,
												  @Context HttpHeaders headers){
		String url = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Url : "  + url + ", \n" +
				"Cookies : " + cookies;
	}
	
	@GET
	@Path("beanParamDemo/{pathParam1}/{pathParam2}")
	public String getValuesFromBean(@BeanParam MyBeanParam myBeanParam){
		return 	"pathParam1 : " + myBeanParam.getPathParamValue1() + ", \n" +
				"queryParam1 : " + myBeanParam.getQueryParamValue1() + ", \n" +
				"queryParam2 : " + myBeanParam.getQueryParamValue2() + ", \n" +
				"pathParam2 : " + myBeanParam.getPathParamValue2();
	}
}
