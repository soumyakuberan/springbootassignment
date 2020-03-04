package dbs.assignment.rest;

import dbs.assignment.documents.OrderTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/transaction")
public class OrderTransactionController {

  @Autowired private JmsTemplate jmsTemplate;

  @PostMapping(path="/send",consumes = "application/json")
  public void send(@RequestBody OrderTransaction transaction) {
    System.out.println("Sending a transaction!!!!!"+transaction);
    jmsTemplate.convertAndSend(
        "OrderTransactionQueue", transaction);
  }
}
