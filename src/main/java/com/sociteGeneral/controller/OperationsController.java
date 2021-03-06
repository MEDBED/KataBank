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
    OperationsServices operationsService;

    //creating a get mapping that retrieves all the Operations detail from the database
    @GetMapping("/Operations")
    private List<Operations> getAllOperationss()
    {
        return operationsService.getAllOperations();
    }

    //creating a get mapping that retrieves the detail of a specific client
    @GetMapping("/Operations/{clientId}")
    public List<Operations> getOperationByiDClient(@PathVariable("clientId") int clientId)
    {
        return operationsService.getOperationsByClientId(clientId);
    }

    //creating a delete mapping that deletes a specified operartion for a specific client
    @DeleteMapping("/DeleteOperations/{clientId}")
    private void deleteOperations(@PathVariable("clientId") int clientId)
    {
        operationsService.delete(clientId);
    }

    //creating post mapping that post the bankAcount detail in the database
    @PostMapping("/newOperation")
    private int saveBankAcount(@RequestBody Operations operation)
    {
        operationsService.saveOrUpdate(operation);
        return operation.getClientiId();
    }
}
