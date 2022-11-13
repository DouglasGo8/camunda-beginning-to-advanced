package com.udemy.camunda.bpm.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Leave {
  private final String name;
  private final int rate;
}
