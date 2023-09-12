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
public class Request implements Serializable {
    private Object data;
    private Operation operation;

    public Object getData() {
        return data;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
