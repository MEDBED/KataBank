package com.sociteGeneral.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.sociteGeneral.model.Operations;
import com.sociteGeneral.service.OperationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sociteGeneral.model.BankAcount;
import com.sociteGeneral.service.BankAcountService;

//mark class as Controller
@RestController
public class BankAcountController {

    //autowire the BankAcountService class
    @Autowired
    BankAcountService bankAcountService;
    OperationsServices operationsServices;

    Operations tmpOperation ;

    //creating a get mapping that retrieves all the bankAcount detail from the database
    @GetMapping("/bankAcounts")
    private List<BankAcount> getAllBankAcouunts()
    {
        return bankAcountService.getAllBankAcounts();
    }

    //creating a get mapping that retrieves the detail of a specific bankAcount
    @GetMapping("/bankAcount/{Iban}")
    private BankAcount getBankAcount(@PathVariable("Iban") int acountId)
    {
        return bankAcountService.getBankAcountById(acountId);
    }

    //creating a delete mapping that deletes a specified bankAcount
    @DeleteMapping("/bankAcount/{Iban}")
    private void deleteBankAcount(@PathVariable("Iban") int acounId)
    {
        bankAcountService.delete(acounId);
    }

    //creating post mapping that post the bankAcount detail in the database
    @PostMapping("/creatBankAcount")
    private int saveBankAcount(@RequestBody BankAcount bankAcount)
    {
        bankAcountService.saveOrUpdate(bankAcount);
        return bankAcount.getIban();
    }

    //creating put mapping that updates the bankAcount detail
    @PutMapping("/ubdateBankAcount")
    private BankAcount update(@RequestBody BankAcount bankAcount)
    {
        bankAcountService.saveOrUpdate(bankAcount);
        return bankAcount;
    }

    //creating post mapping that create new operation
    @PostMapping("/operation/{Type}")
    private void withdraw(@PathVariable("Type") String operationType, int acounId, float amount)
    {
        if (operationType == "withdrow" ){
            bankAcountService.withdraw(acounId, amount);
        }else{
            bankAcountService.deposit(acounId, amount);
        }
        this.tmpOperation.setAmount(amount);
        this.tmpOperation.setClientId(acounId);
        this.tmpOperation.setOperation(operationType);
        this.tmpOperation.setDate(LocalDateTime.now());
        operationsServices.saveOrUpdate(tmpOperation);
    }

}
