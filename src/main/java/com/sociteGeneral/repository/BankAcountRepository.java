package com.sociteGeneral.repository;

import org.springframework.data.repository.CrudRepository;
import com.sociteGeneral.model.BankAcount;
import org.springframework.stereotype.Component;

//repository that extends CrudRepository
@Component
public interface BankAcountRepository extends CrudRepository<BankAcount, Integer>  {
}
