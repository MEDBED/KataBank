package com.sociteGeneral.service;

import java.util.ArrayList;
import java.util.List;

import com.sociteGeneral.repository.BankAcountRepository;
import com.sociteGeneral.model.BankAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class BankAcountService {

    @Autowired
    BankAcountRepository bankAcountRepository;

    //getting all bankAcounts record by using the method findaAll() of CrudRepository
    public List<BankAcount> getAllBankAcounts() {
        List<BankAcount> bankAcounts = new ArrayList<BankAcount>();
        bankAcountRepository.findAll().forEach(bankAcount -> bankAcounts.add(bankAcount));
        return bankAcounts;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public BankAcount getBankAcountById(int iban) {
        return bankAcountRepository.findById(iban).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(BankAcount bankAcount) {
        bankAcountRepository.save(bankAcount);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int iban) {

        bankAcountRepository.deleteById(iban);
    }

    //updating a record
    public void update(BankAcount bankAcount, int iban) {
        bankAcountRepository.save(bankAcount);
    }

    public void withdraw(int Iban,   float amount)
    {
        BankAcount ba;
        ba = getBankAcountById(Iban);
        ba.balance = ba.balance - amount;
        update(ba,Iban);

    }

    public void deposit(int Iban,   float amount)
    {
        BankAcount ba;
        ba = getBankAcountById(Iban);
        ba.balance = ba.balance + amount;
        update(ba,Iban);

    }



}
