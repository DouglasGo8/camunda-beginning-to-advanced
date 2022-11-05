package com.udemy.camunda.bpm.interrupting.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author dougdb
 */
@Component("orderValidate")
public class OrderValidate implements JavaDelegate {

  private final Logger LOGGER = Logger.getLogger(OrderValidate.class.getName());


  @Override
  public void execute(DelegateExecution execution) {

    LOGGER.info("OrderValidate: executed has been called...");

    final String orderName = (String) execution.getVariable("orderName");

    if (!orderName.isEmpty()) {
      LOGGER.info("the content in orderName variable is " + orderName);
      execution.setVariable("isValidate", true);
    } else {
      LOGGER.info("orderName Variable is Empty");
      execution.setVariable("isValidate", false);
    }
  }
}
