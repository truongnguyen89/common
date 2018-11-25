package com.football.common.exception;

import com.football.common.response.Response;
import com.football.common.util.StringCommon;
import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {
    private Response response;
    private HttpStatus status;
    private String message;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
        this.status = response.getStatus();
    }

    public CommonException() {

    }

    @Deprecated
    public CommonException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public CommonException(Response response, String message) {
        super(message);
        this.response = response;
        this.status = response.getStatus();
        this.message = message;
    }

    public CommonException(HttpStatus status, String responseCode, String message) {
        super(message);
        this.response.setResponseCode(responseCode);
        this.response.setDescription(message);
        this.status = response.getStatus();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"responseCode\":").append("\"").append(this.getResponse().getResponseCode()).append("\"").append(",");
        stringBuilder.append("\"description\":").append("\"").append(StringCommon.isNullOrBlank(this.getMessage()) ? this.getResponse().getDescription() : this.getMessage()).append("\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
