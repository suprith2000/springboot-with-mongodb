package com.java.folk.spring_boot_mongodb_tutorial.repository;

import com.java.folk.spring_boot_mongodb_tutorial.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense,String> {

    @Query("{'name':?0}")
    Optional<Expense> findByName(String name);
}
