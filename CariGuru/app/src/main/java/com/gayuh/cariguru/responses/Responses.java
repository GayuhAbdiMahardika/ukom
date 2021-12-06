package com.gayuh.cariguru.responses;

//import com.gayuh.cariguru.model.Data;

public interface Responses {
    String message = null;
    Boolean ok = false;
    Object data = null;

    public String getMessage();

    public Boolean getOk();

    public Object   getData();
}
