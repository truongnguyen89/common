package com.football.common.response;

import com.football.common.util.StringCommon;
import org.springframework.http.HttpStatus;

public enum Response {

    OK("000", HttpStatus.OK, "OK"),
    CREATED("201", HttpStatus.CREATED, "Created"),
    ACCEPTED("202", HttpStatus.ACCEPTED, "Accepted"),
    BAD_REQUEST("400", HttpStatus.BAD_REQUEST, "Bad request"),
    NOT_FOUND("404", HttpStatus.NOT_FOUND, "Not found"),
    REQUEST_TIMEOUT("408", HttpStatus.REQUEST_TIMEOUT, "Request Timeout"),
    UNAUTHORIZED("401", HttpStatus.UNAUTHORIZED, "Non-Authoritative Information"),
    INVALID_PERMISSION("403", HttpStatus.FORBIDDEN, "Invalid Permission"),
    OBJECT_IS_EXIST("0001", HttpStatus.OK, "Object is exist"),
    OBJECT_NOT_FOUND("0002", HttpStatus.OK, "Object not found"),
    REQUIRED_PARAMETERS_MAY_NOT_BE_BLANK("0003", HttpStatus.OK, "Required parameters may not be blank"),
    PROVIDER_INVALID("0004", HttpStatus.OK, "Provider invalid"),
    FAILED_TO_SEND_MAIL("0003", HttpStatus.OK, "Failed to send mail"),
    FAILED_TO_LOGIN_MAIL_SERVER("0004", HttpStatus.OK, "Failed to login mail server"),
    PARAM_IS_NULL_ACTIVE("0005", HttpStatus.OK, "Param list is empty"),
    CUSTOMER_NOT_FOUND("0017", HttpStatus.OK, "Customer not found"),
    BILL_NOT_FOUND("0025", HttpStatus.OK, "Bill not found"),
    ERR_TIME_OUT_WHEN_REQUEST_EDONG_CLIENT("2031", HttpStatus.OK, "Không có kết quả trả về khi request sang CORE"),
    ERROR_CORE_UNKNOWN("999", HttpStatus.OK, "Có lỗi khi thực hiện nghiệp vụ trong CORE."),
    INTERNAL_SERVER_ERROR("500", HttpStatus.INTERNAL_SERVER_ERROR, "Error unknown.");
    private String responseCode;
    private HttpStatus status;
    private String description;

    private Response(String responseCode, HttpStatus status, String description) {
        this.responseCode = responseCode;
        this.status = status;
        this.description = description;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setResponseStatus(HttpStatus status) {
        this.status = status;
        this.responseCode = String.valueOf(status.value());
        this.description = status.getReasonPhrase();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"responseCode\":").append("\"").append(this.responseCode).append("\"").append(",");
        stringBuilder.append("\"description\":").append("\"").append(this.description).append("\"").append(",");
        stringBuilder.append("\"").append(this.status.name()).append("\":");
        stringBuilder.append("{");
        stringBuilder.append("\"value\":").append("\"").append(this.status.value()).append("\"").append(",");
        stringBuilder.append("\"reasonPhrase\":").append("\"").append(this.status.getReasonPhrase()).append("\"");
        stringBuilder.append("}");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
