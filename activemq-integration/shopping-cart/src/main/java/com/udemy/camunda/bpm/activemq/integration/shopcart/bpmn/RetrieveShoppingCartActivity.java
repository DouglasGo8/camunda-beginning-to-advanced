package com.udemy.camunda.bpm.activemq.integration.shopcart.bpmn;


import com.udemy.camunda.bpm.activemq.integration.shopcart.ProcessConstants;
import com.udemy.camunda.bpm.activemq.integration.shopcart.service.ShoppingCartManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component("retrieveShoppingCartActivity")
public class RetrieveShoppingCartActivity implements JavaDelegate {

  private final ShoppingCartManager shoppingCartManager;

  @Override
  public void execute(DelegateExecution execution) {
    log.info("execute {} - {}", ProcessConstants.SERVICE_NAME_SHOPPING_CART, "retrieve");
    String scId = (String) execution.getVariable(ProcessConstants.VAR_SC_ID);


  }
}
