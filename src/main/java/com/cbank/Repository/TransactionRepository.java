package com.cbank.Repository;

import com.cbank.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // List<Transaction> findBySenderNameOrRecipientName(String senderName, String
    // recipientName);
}