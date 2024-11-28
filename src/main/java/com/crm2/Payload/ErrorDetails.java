package com.crm2.Payload;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String message;
    private String request;

    public ErrorDetails(String message, Date date, String request) {
        this.message = message;
        this.date = date;
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
