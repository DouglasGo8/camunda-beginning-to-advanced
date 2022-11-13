package com.udemy.camunda.bpm.jdbc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {
  private final int id;
  private final int age;
  private final String name;
}
