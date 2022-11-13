package com.udemy.camunda.bpm.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import java.util.Date;

public class ApplicationStartListener implements ExecutionListener {
  @Override
  public void notify(DelegateExecution execution) {
    execution.setVariable("startDate", new Date());

  }
}
