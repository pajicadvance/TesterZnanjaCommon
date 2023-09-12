/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.communication;

import java.io.Serializable;

/**
 *
 * @author Pavle
 */
public class Response implements Serializable {
    private Object data;
    private Exception exception;

    public Object getData() {
        return data;
    }

    public Exception getException() {
        return exception;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
