package com.udemy.camunda.bpm.service;

import com.udemy.camunda.bpm.domain.Leave;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component("leaveApplyServiceTask")
public class LeaveApplyServiceTask implements JavaDelegate {

  private static final Logger LOGGER = Logger.getLogger(LeaveApplyServiceTask.class.getName());

  @Override
  public void execute(DelegateExecution execution) {

    LOGGER.info("Data Initializer Service Task called");
    //

    List<Leave> leaveAppliedByEmployees = new ArrayList<>();

    leaveAppliedByEmployees.add(new Leave("Mary", 10));
    leaveAppliedByEmployees.add(new Leave( "John", 20));
    leaveAppliedByEmployees.add(new Leave("Cage", 5));
    //

    execution.setVariable("leaveDaysCountList", leaveAppliedByEmployees);
    execution.setVariable("leaveAppliedByEmployeesSize", leaveAppliedByEmployees.size());



  }
}
