package com.java.folk.spring_boot_mongodb_tutorial.service;

import com.java.folk.spring_boot_mongodb_tutorial.model.Expense;
import com.java.folk.spring_boot_mongodb_tutorial.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    public ExpenseRepository expenseRepository;

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("cannot Find Expense by Id %s",expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);

    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("cannot Find Expense by Name %s", name)));

    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
