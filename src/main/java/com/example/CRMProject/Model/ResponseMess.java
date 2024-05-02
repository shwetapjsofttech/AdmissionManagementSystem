package com.example.CRMProject.Model;


public class ResponseMess {

    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMess{" +
                "message='" + message + '\'' +
                '}';
    }

    public ResponseMess(String message) {
        this.message = message;
    }
}
