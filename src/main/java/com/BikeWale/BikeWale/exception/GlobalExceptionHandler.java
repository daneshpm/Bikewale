package com.BikeWale.BikeWale.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.BikeWale.BikeWale.entity.ApiErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ApiErrorResponse buildError(HttpServletRequest req, int status, String error, String message) {

        ApiErrorResponse body = new ApiErrorResponse();
        body.setStatusCode(status);
        body.setError(error);
        body.setMessage(message);
        body.setPath(req.getRequestURI());

        return body;
    }

    //  ID Not Found
    @ExceptionHandler(IDNotPresentException.class)
    public ApiErrorResponse idNotFound(IDNotPresentException ex, HttpServletRequest req) {
        return buildError(req, 404, "ID Not Found", ex.getMessage());
    }

    //  Relationship not found
    @ExceptionHandler(RelationNotFoundException.class)
    public ApiErrorResponse relationNotFound(RelationNotFoundException ex, HttpServletRequest req) {
        return buildError(req, 400, "Relationship Missing", ex.getMessage());
    }

    // Invalid Input
    @ExceptionHandler(InvalidInputException.class)
    public ApiErrorResponse invalidInput(InvalidInputException ex, HttpServletRequest req) {
        return buildError(req, 422, "Invalid Input", ex.getMessage());
    }

    // Duplicate Entry
    @ExceptionHandler(DuplicateEntryException.class)
    public ApiErrorResponse duplicateEntry(DuplicateEntryException ex, HttpServletRequest req) {
        return buildError(req, 409, "Duplicate Entry", ex.getMessage());
    }

    // Validation Exception
    @ExceptionHandler(ValidationException.class)
    public ApiErrorResponse validationException(ValidationException ex, HttpServletRequest req) {
        return buildError(req, 400, "Validation Failed", ex.getMessage());
    }

    //  Number format exception
    @ExceptionHandler(NumberFormatException.class)
    public ApiErrorResponse numberFormat(NumberFormatException ex, HttpServletRequest req) {
        return buildError(req, 400, "Number Format Error", ex.getMessage());
    }

    //  NullPointer + Arithmetic
    @ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
    public ApiErrorResponse commonErrors(Exception ex, HttpServletRequest req) {
        return buildError(req, 500, "Runtime Error", ex.getMessage());
    }

    //  Generic fallback
    @ExceptionHandler(Exception.class)
    public ApiErrorResponse generic(Exception ex, HttpServletRequest req) {
        return buildError(req, 500, "Internal Server Error", ex.getMessage());
    }
}
