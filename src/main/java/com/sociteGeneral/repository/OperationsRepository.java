package com.sociteGeneral.repository;

import org.springframework.data.repository.CrudRepository;
import com.sociteGeneral.model.Operations;
import org.springframework.stereotype.Component;

@Component
public interface OperationsRepository extends CrudRepository<Operations, Integer> {
}
