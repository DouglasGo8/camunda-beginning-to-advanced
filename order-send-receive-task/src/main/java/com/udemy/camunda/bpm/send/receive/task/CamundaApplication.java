package com.udemy.camunda.bpm.send.receive.task;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@EnableProcessApplication("order-send-receive-task")
public class CamundaApplication implements CommandLineRunner {

  @Resource
  private RuntimeService runtimeService;

  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }


  @Override
  public void run(String... args) {
    final String businessKey = UUID.randomUUID().toString();

    final Map<String, Object> processOrderData = new HashMap<>();

    processOrderData.put("customerName", "Douglas Batista");
    processOrderData.put("item", "mobile");
    processOrderData.put("giftPackingIsNeeded", true);
    processOrderData.put("zipCode", "123456");


    final Map<String, Object> processOrderDataForShipment = new HashMap<>();

    processOrderDataForShipment.put("customerName", "Douglas Batista");
    processOrderDataForShipment.put("item", "mobile");
    processOrderDataForShipment.put("zipCode", "123456");

    // Starting the first order-send-receive-task BPMN
    runtimeService.startProcessInstanceByKey("order-send-receive-task", businessKey, processOrderData);

    // Starting the ship-send-receive-task BPMN with same business key
    runtimeService.startProcessInstanceByKey("ship-send-receive-task", businessKey, processOrderDataForShipment);

  }
}
