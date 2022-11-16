package com.udemy.camunda.bpm.async.transactions.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service("validateOrder")
public class OderValidatorServiceTask implements JavaDelegate {

  @Override
  @SneakyThrows
  public void execute(DelegateExecution execution) {
    log.info("OderValidatorServiceTask called");
    final String isValidated = "Validation successfully done";
    execution.setVariable("isValidated", isValidated);
    log.info("Order Validation status is --> isValidated: " + isValidated);
    log.info("Waiting....");
    TimeUnit.SECONDS.sleep(15);
  }
}
