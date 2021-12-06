package com.gayuh.cariguru.model;

import java.util.List;

public class ResponsesGetPenawaranGuru {
    private String message,ok;
    private List<PenawaranModel> data;

    public ResponsesGetPenawaranGuru(String message, String ok, List<PenawaranModel> data) {
        this.message = message;
        this.ok = ok;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<PenawaranModel> getData() {
        return data;
    }

    public void setData(List<PenawaranModel> data) {
        this.data = data;
    }
}


