package com.udemy.camunda.bpm.jdbc.util;

import com.udemy.camunda.bpm.jdbc.domain.Employee;

public class ValidatorUtil {

  public static boolean validateEmployeeData(Employee employee) {
    return employee.getId() > 0;
  }
}
