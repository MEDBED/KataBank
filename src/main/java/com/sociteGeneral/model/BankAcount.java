package com.sociteGeneral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class BankAcount {
    //Defining book id as primary key
    @Id
    @Column
    private int acountId;
    @Column
    private String clientName;
    @Column
    private float balance;

    public int getAcountiId() { return acountId; }

    public void setAcountiId(int acountId) {
        this.acountId = acountId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


}
