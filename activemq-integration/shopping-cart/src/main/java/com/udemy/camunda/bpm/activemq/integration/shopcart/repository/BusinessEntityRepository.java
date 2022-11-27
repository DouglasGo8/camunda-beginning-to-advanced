package com.udemy.camunda.bpm.activemq.integration.shopcart.repository;

import com.udemy.camunda.bpm.activemq.integration.shopcart.entities.BusinessEntityJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessEntityRepository extends CrudRepository<BusinessEntityJpa, String> {
}
