package com.udemy.camunda.bpm.jdbc.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("saveEmployee")
public class EmployeeSaveData implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) {
    // delegates to Apache Camel JDBC
    execution.setVariable("isSaved", true);
  }
}
