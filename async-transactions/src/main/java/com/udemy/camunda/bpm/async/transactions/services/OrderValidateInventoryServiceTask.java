package com.udemy.camunda.bpm.async.transactions.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service("checkOrder")
public class OrderValidateInventoryServiceTask implements JavaDelegate {

  private static int retryCounter = 0;

  @Override
  @SneakyThrows
  public void execute(DelegateExecution execution) {

    OrderValidateInventoryServiceTask.retryCounter++;

    log.info("OrderValidateInventoryServiceTask called");

    if (OrderValidateInventoryServiceTask.retryCounter <= 3) {
      execution.setVariable("isAvailable", "no");
      log.info("Inventory service called... retry counter" + OrderValidateInventoryServiceTask.retryCounter);
      log.info("I'll wait for 20 seconds before throwing the exception.. check the execution variable");
      //
      TimeUnit.SECONDS.sleep(20);
      throw new RuntimeException("Service not available");
    } else {
      log.info("Inventory service called... retry conuter " + OrderValidateInventoryServiceTask.retryCounter);
      execution.setVariable("isAvailable", "yes");
    }
    execution.setVariable("retryCounter", OrderValidateInventoryServiceTask.retryCounter);
  }
}
