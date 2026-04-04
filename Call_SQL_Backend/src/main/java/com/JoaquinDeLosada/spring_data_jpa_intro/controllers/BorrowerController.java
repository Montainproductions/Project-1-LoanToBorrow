package com.JoaquinDeLosada.spring_data_jpa_intro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.Borrower;
import com.JoaquinDeLosada.spring_data_jpa_intro.models.Loan;
import com.JoaquinDeLosada.spring_data_jpa_intro.services.BorrowerService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/BorrowerList")
public class BorrowerController {

    private final BorrowerService borrowerService;

    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    public ResponseEntity<List<Borrower>> getAllBorrower(
        @RequestParam(defaultValue = "4") int size,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        return new ResponseEntity<>(borrowerService.getAllBorrowers(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable int id) {
        Borrower borrower = borrowerService.getBorrowerById(id);
        
        if(borrower == null) {
            return ResponseEntity.notFound().build();
        }
        
        return new ResponseEntity<>(borrower, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Borrower> createBorrower(@Valid @RequestBody Borrower newBorrower) {
        Borrower borrower = borrowerService.saveBorrower(newBorrower);
        if(borrower == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(borrower, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable int id) {
        borrowerService.deleteBorrowerById(id);
        return ResponseEntity.noContent().build();
    }
    
}
