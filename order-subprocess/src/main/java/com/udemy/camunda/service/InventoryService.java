package com.udemy.camunda.service;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("inventoryService")
public class InventoryService implements JavaDelegate {

  private final Logger LOGGER = Logger.getLogger(InventoryService.class.getName());


  @Override
  public void execute(DelegateExecution execution) {
    String productCode = (String) execution.getVariable("productCode");

    LOGGER.info("productCode is " + productCode);

    int productCodeCount = 0;

    execution.setVariable("productCodeCount", productCodeCount);

    if (productCodeCount <= 0) {
      try {
        throw new BpmnError("Product_Not_Available", "this product is not available");
      } catch (BpmnError e) {
        LOGGER.info(" execution occured: product count is " + productCode);
        execution.setVariable("errorCode", "Product_Not_Available");
        execution.setVariable("errorMessage", "This product is not available");
        throw e;
      }
    }

  }
}
