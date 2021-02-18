package com.sociteGeneral.service;

import com.sociteGeneral.model.BankAcount;
import com.sociteGeneral.model.Operations;

import java.util.ArrayList;
import java.util.List;
import com.sociteGeneral.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service

public class OperationsServices {
    @Autowired
    OperationsRepository operationsRepository;

    public static Operations getOperationsByClientId(int clientId) {
        return null;
    }

    public List<Operations> getAllOperations() {

        List<Operations> Operation = new ArrayList<Operations>();
        operationsRepository.findAll().forEach(operations1 -> Operation.add(operations1));
        return Operation;
    }

    public void delete(int clientId) {
    }

    public void saveOrUpdate(Operations operation) {
    }
}
