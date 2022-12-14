package com.nttdata.bootcamp.exchangebootcoinservice.infrastructure;

import com.nttdata.bootcamp.exchangebootcoinservice.domain.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
