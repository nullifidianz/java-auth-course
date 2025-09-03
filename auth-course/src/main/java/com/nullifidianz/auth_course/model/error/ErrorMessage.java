package com.nullifidianz.auth_course.model.error;

public class ErrorMessage {
    private String title;
    private String message;
    private Integer statusCode;

    public ErrorMessage() {
    }

    public ErrorMessage(String title, String message, Integer statusCode) {
        this.title = title;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
