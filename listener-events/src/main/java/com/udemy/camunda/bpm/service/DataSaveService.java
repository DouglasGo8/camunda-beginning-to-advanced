package com.udemy.camunda.bpm.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component("dataSaveService")
public class DataSaveService implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    execution.setVariable("isDateSaved", "saved");
  }
}
