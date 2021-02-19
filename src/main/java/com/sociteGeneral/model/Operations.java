package com.sociteGeneral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table

public class Operations {

    @Id
    @Column
    private int clientId;
    @Column
    private String operation;
    @Column
    private LocalDateTime date;
    @Column
    private float amount;

    public int getClientiId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
