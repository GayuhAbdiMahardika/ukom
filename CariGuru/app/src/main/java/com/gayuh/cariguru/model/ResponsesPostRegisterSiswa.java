package com.gayuh.cariguru.model;

public class ResponsesPostRegisterSiswa {
    private String message, data;
    private Boolean ok;

    public ResponsesPostRegisterSiswa(String message, String data, Boolean ok) {
        this.message = message;
        this.data = data;
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
