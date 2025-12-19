package com.fsg.bikeWale.util;

import com.fsg.bikeWale.entity.ApiErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

public class ApiErrorUtil {

	private ApiErrorUtil() {
		
	}

	public static ApiErrorResponse build(HttpServletRequest req, int status, String error, String message) {

		ApiErrorResponse body = new ApiErrorResponse();
		body.setStatusCode(status);
		body.setError(error);
		body.setMessage(message);
		body.setPath(req.getRequestURI());

		return body;
	}
}