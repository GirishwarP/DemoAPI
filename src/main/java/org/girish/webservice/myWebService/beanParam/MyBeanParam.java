package org.girish.webservice.myWebService.beanParam;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class MyBeanParam {

	private @PathParam("pathParam1") String pathParamValue1; 
	private @QueryParam("queryParam1") String queryParamValue1;
	private @QueryParam("queryParam2") int queryParamValue2;
	private @PathParam("pathParam2") int pathParamValue2;
	
	public String getPathParamValue1() {
		return pathParamValue1;
	}
	public void setPathParamValue1(String pathParamValue1) {
		this.pathParamValue1 = pathParamValue1;
	}
	public String getQueryParamValue1() {
		return queryParamValue1;
	}
	public void setQueryParamValue1(String queryParamValue1) {
		this.queryParamValue1 = queryParamValue1;
	}
	public int getQueryParamValue2() {
		return queryParamValue2;
	}
	public void setQueryParamValue2(int queryParamValue2) {
		this.queryParamValue2 = queryParamValue2;
	}
	public int getPathParamValue2() {
		return pathParamValue2;
	}
	public void setPathParamValue2(int pathParamValue2) {
		this.pathParamValue2 = pathParamValue2;
	}
}
