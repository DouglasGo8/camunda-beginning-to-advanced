package com.udemy.camunda.bpm.rest.wrapper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {
  private final int empId;
  private final String empName;
}
