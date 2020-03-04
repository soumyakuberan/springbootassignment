package dbs.assignment.jms;

import dbs.assignment.documents.OrderTransaction;
import dbs.assignment.repositories.OrderTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionReceiver {

  @Autowired private OrderTransactionRepository transactionRepository;

  private int count = 1;

  @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
  public void receiveMessage(OrderTransaction transaction) {
    System.out.println("<" + count + "> Received <" + transaction + ">");
    count++;
    System.out.println("Transaction :"+transaction);
    //    throw new RuntimeException();
    transactionRepository.save(transaction);
  }
 }
