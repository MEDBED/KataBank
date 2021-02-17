package com.sociteGeneral.controller;

import com.sociteGeneral.model.BankAcount;
import com.sociteGeneral.service.BankAcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sociteGeneral.model.Operations;
import com.sociteGeneral.service.OperationsServices;

import java.util.List;

//mark class as Controller
@RestController

public class OperationsController {

    //autowire the OperationsService class
    @Autowired
    BankAcountService bankAcountService;
    //creating a get mapping that retrieves all the Operations detail from the database
    @GetMapping("/bankAcounts")
    private List<BankAcount> getAllBankAcouunts()
    {
        return bankAcountService.getAllBankAcounts();
    }

    //creating a get mapping that retrieves the detail of a specific bankAcount
    @GetMapping("/bankAcount/{acountId}")
    private BankAcount getBankAcount(@PathVariable("acountId") int acountId)
    {
        return bankAcountService.getBankAcountById(acountId);
    }

    //creating a delete mapping that deletes a specified bankAcount
    @DeleteMapping("/bankAcount/{acountId}")
    private void deleteBankAcount(@PathVariable("acountId") int acounId)
    {
        bankAcountService.delete(acounId);
    }

    //creating post mapping that post the bankAcount detail in the database
    @PostMapping("/creatBankAcount")
    private int saveBankAcount(@RequestBody BankAcount bankAcount)
    {
        bankAcountService.saveOrUpdate(bankAcount);
        return bankAcount.getAcountiId();
    }

    //creating put mapping that updates the bankAcount detail
    @PutMapping("/ubdateBankAcount")
    private BankAcount update(@RequestBody BankAcount bankAcount)
    {
        bankAcountService.saveOrUpdate(bankAcount);
        return bankAcount;
    }
}
