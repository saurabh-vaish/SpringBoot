package com.app.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 *  Filters are used in zuul server to pre process and post process request and response . 
 *  There are 4 types of filters .
 *  
 *  	MyFilter ----> ZuulFilter (AC) ---> IZuulFilter (I)
 *  
 *  
 *  PreFilter , PostFilter , RouteFilter , ExceptionFilter 
 * 
 * 	PreFilter --> Works on request 
 * 
 * 	PostFilter --> Works on response 
 * 
 * 	RouteFilter --> Works on service instance object
 * 
 * 	ExceptionFilter --> Works only if exception is rased   
 * 
 * 
 * **/

@Component
public class PostFilter extends ZuulFilter{

	// to enable and disable filter
	public boolean shouldFilter() {
		return true;
	}

	
	// to provide work or loginc for filter , for postfilter - data conversion , encodeing ,decoding etc .
	public Object run() throws ZuulException {
		System.out.println("From Post Filter");
		return null;
	}

	
	// specify which filter it is
	public String filterType() {
		return FilterConstants.POST_TYPE;
		// return "post";  					/// also can be  defined as 
	}

	
	
	// specifies execution order if multiple filter of same type are running
	public int filterOrder() {
		return 0;
	}

}
