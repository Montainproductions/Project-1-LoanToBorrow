package com.JoaquinDeLosada.spring_data_jpa_intro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.Loan;
import com.JoaquinDeLosada.spring_data_jpa_intro.services.LoanService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoan(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "4") int size,
        @RequestParam(defaultValue = "id") String sortBy
    ) {

        List<Loan> loans = loanService.getAllLoans(page, size, sortBy);

        if(loans == null) {
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanbyId(@PathVariable int id) {

        Loan loan = loanService.getLoanById(id);
        
        if(loan == null) {
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Loan> createMovie(@Valid @RequestBody Loan newLoan) {
        Loan loan = loanService.saveLoan(newLoan);
        
        if(loan == null) {
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable int id, @Valid @RequestBody Loan loanToUpdate) {
        Loan loan = loanService.saveLoan(loanToUpdate);
        if(loan == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable int id) {
        boolean isLoanDeleted = loanService.deleteLoan(id);
        if(isLoanDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       return ResponseEntity.notFound().build();
    }
}
