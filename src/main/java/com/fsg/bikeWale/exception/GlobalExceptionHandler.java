package com.fsg.bikeWale.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fsg.bikeWale.entity.ApiErrorResponse;
import com.fsg.bikeWale.util.ApiErrorUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// ID Not Found
	@ExceptionHandler(IDNotPresentException.class)
	public ApiErrorResponse idNotFound(IDNotPresentException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 404, "ID Not Found", ex.getMessage());
	}

	// Relationship not found
	@ExceptionHandler(RelationNotFoundException.class)
	public ApiErrorResponse relationNotFound(RelationNotFoundException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 400, "Relationship Missing", ex.getMessage());
	}

	// Invalid Input
	@ExceptionHandler(InvalidInputException.class)
	public ApiErrorResponse invalidInput(InvalidInputException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 422, "Invalid Input", ex.getMessage());
	}

	// Duplicate Entry
	@ExceptionHandler(DuplicateEntryException.class)
	public ApiErrorResponse duplicateEntry(DuplicateEntryException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 409, "Duplicate Entry", ex.getMessage());
	}

	// Validation Exception
	@ExceptionHandler(ValidationException.class)
	public ApiErrorResponse validationException(ValidationException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 400, "Validation Failed", ex.getMessage());
	}

	// Number format
	@ExceptionHandler(NumberFormatException.class)
	public ApiErrorResponse numberFormat(NumberFormatException ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 400, "Number Format Error", ex.getMessage());
	}

	// Runtime errors
	@ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
	public ApiErrorResponse commonErrors(Exception ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 500, "Runtime Error", ex.getMessage());
	}

	// Fallback
	@ExceptionHandler(Exception.class)
	public ApiErrorResponse generic(Exception ex, HttpServletRequest req) {

		return ApiErrorUtil.build(req, 500, "Internal Server Error", ex.getMessage());
	}
}