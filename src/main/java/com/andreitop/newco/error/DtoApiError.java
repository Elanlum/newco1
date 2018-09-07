package com.andreitop.newco.error;

public class DtoApiError {

    private int errorCode;
    private String errorMessage;

    public DtoApiError() {
        super();
    }

    public DtoApiError(int errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
