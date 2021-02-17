package com.sociteGeneral.service;

import java.util.ArrayList;
import java.util.List;

import com.sociteGeneral.repository.BankAcountRepository;

import com.sociteGeneral.model.BankAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class bankAcountService {
    @Autowired
    BankAcountRepository bankAcountRepository;

    //getting all bankAcounts record by using the method findaAll() of CrudRepository
    public List<BankAcount> getAllBankAcounts() {
        List<BankAcount> bankAcounts = new ArrayList<BankAcount>();
        bankAcountRepository.findAll().forEach(bankAcount1 -> bankAcounts.add(bankAcount1));
        return bankAcounts;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public BankAcount getBankAcountById(int acountId) {
        return bankAcountRepository.findById(acountId).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(BankAcount bankAcount) {
        bankAcountRepository.save(bankAcount);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int acountId) {
        bankAcountRepository.deleteById(acountId);
    }

    //updating a record
    public void update(BankAcount bankAcount, int acountId) {
        bankAcountRepository.save(bankAcount);
    }



}
