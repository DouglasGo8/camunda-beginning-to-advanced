package com.udemy.camunda.bpm.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class DataSaveServiceEndListener implements ExecutionListener {
  @Override
  public void notify(DelegateExecution execution) {
    execution.setVariable("serviceListenerName", DataSaveServiceEndListener.class.getName());
  }
}
