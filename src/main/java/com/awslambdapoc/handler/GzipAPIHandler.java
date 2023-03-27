package com.awslambdapoc.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.awslambdapoc.ApiGatewayResponse;
import com.awslambdapoc.util.ResponseUtil;

public class GzipAPIHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(GzipAPIHandler.class);

	/**
	 * API is using same data but with gzip
	 * 
	 */
	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);
		Map<String,String> headers= new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Content-Encoding", "gzip");
		headers.put("access-control-allow-origin", "*");
		try {
			return ApiGatewayResponse.builder()
					.setStatusCode(200)
					.setBase64Encoded(true)
					.setBinaryBody(ResponseUtil.compress(ResponseUtil.getData()).toByteArray())
					.setHeaders(headers)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ApiGatewayResponse.builder()
				.setStatusCode(500)
				.setBase64Encoded(true)
				.setObjectBody("failed")
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}

}
