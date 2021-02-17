package com.sociteGeneral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Operations {

    @Id
    @Column
    private int clientId;
    @Column
    private String operation;
    @Column
    private String date;
    @Column
    private float amount;

    public int getClientiId() {
        return clientId;
    }

    public void setAcountiId(int clientId) {
        this.clientId = clientId;
    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
