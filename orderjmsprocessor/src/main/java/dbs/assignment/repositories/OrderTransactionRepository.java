package dbs.assignment.repositories;

import dbs.assignment.documents.OrderTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {}
