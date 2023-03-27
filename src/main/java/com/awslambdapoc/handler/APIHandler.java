package com.awslambdapoc.handler;

import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.awslambdapoc.ApiGatewayResponse;
import com.awslambdapoc.util.ResponseUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * API is using same data but without gzip
 * 
 */
public class APIHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(APIHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String str = gson.toJson(ResponseUtil.getData());
		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(str)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless")).build();
	}

}
