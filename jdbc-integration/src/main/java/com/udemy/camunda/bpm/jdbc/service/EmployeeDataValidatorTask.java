package com.udemy.camunda.bpm.jdbc.service;

import com.udemy.camunda.bpm.jdbc.domain.Employee;
import com.udemy.camunda.bpm.jdbc.util.ValidatorUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("employeeDataValidator")
public class EmployeeDataValidatorTask implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) {
    //
    final int id = (int) execution.getVariable("id");
    final int age = (int) execution.getVariable("age");
    final String name = (String) execution.getVariable("name");
    //
    final Employee employee = new Employee(id, age, name);
    //
    final boolean isValidated = ValidatorUtil.validateEmployeeData(employee);
    //
    execution.setVariable("employee", employee);
    execution.setVariable("isValidated", isValidated);
  }
}
