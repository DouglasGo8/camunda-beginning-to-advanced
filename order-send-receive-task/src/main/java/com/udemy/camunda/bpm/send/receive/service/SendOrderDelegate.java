package com.udemy.camunda.bpm.send.receive.service;


import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Component("sendOrderDelegate")
public class SendOrderDelegate implements JavaDelegate {

  private final Logger LOGGER = Logger.getLogger(SendOrderDelegate.class.getName());

  @Resource
  RuntimeService runtimeService;


  @Override
  public void execute(DelegateExecution execution) {
    LOGGER.info("SendOrderDelegate.class");

    final MessageCorrelationResult result = runtimeService.createMessageCorrelation("messageShipment")
            .processInstanceBusinessKey(execution.getBusinessKey())
            .setVariable("caller", SendOrderDelegate.class.getName()).correlateWithResult();
    //
    final DelegateExecution shipmentExecution = (DelegateExecution) result.getExecution();
    //
    LOGGER.info("result - " + shipmentExecution.getVariables());
  }
}
