package com.sociteGeneral.repository;

import org.springframework.data.repository.CrudRepository;
import com.sociteGeneral.model.BankAcount;

//repository that extends CrudRepository
public interface BankAcountRepository extends CrudRepository<BankAcount, Integer>  {
}
