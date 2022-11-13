package com.udemy.camunda.bpm.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.model.bpmn.instance.UserTask;

public class ProviderInputTaskListener implements TaskListener {
  @Override
  public void notify(DelegateTask task) {
    // LOGGER.info(this.getClass().getName());
    // LOGGER.info(task.getAssignee());
    // LOGGER.info(task.getEventName());
    // LOGGER.info(task.getValiables());

    UserTask userTask = task.getBpmnModelElementInstance();
    DelegateExecution execution = task.getExecution();
    execution.setVariable("inputTaskCompletedBy", task.getAssignee());
  }
}
