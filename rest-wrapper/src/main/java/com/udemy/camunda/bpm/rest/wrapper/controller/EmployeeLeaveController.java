package com.udemy.camunda.bpm.rest.wrapper.controller;


import com.udemy.camunda.bpm.rest.wrapper.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "emp-leave")
public class EmployeeLeaveController {

  private static final String PROCESS_DEFINITION_KEY = "rest-wrapper";

  @GetMapping
  public String getTheDetails() {
    return "Hello";
  }

  @PostMapping
  public ResponseEntity<HttpStatus> startBPMNProcess(@RequestBody Employee employee) {
    final ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    final RuntimeService runtimeService = processEngine.getRuntimeService();
    final Map<String, Object> processVariable = new HashMap<>();
    //
    processVariable.put("empId", employee.getEmpId());
    processVariable.put("empName", employee.getEmpName());
    //
    final ProcessInstance pi = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, processVariable);
    log.info("Process Instance id {}", pi.getId());
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
