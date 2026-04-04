package com.JoaquinDeLosada.spring_data_jpa_intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.Borrower;
import com.JoaquinDeLosada.spring_data_jpa_intro.repositories.BorrowerRepository;

@Service
public class BorrowerService {

    private final BorrowerRepository repository;

    BorrowerService(BorrowerRepository repository) {
        this.repository = repository;
    }

    public List<Borrower> getAllBorrowers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Borrower> borrowerPage = repository.findAll(pageable);
        List<Borrower> borrowerList = borrowerPage.getContent();
        return borrowerList;
    }

    public Borrower getBorrowerById(int id) {

        if(id < 0){
            return null;
        }

        Optional<Borrower> borrower = repository.findById(id);
        if(borrower.isPresent()) {
            return borrower.get();
        }
        return null;
    }

    @Transactional
    public Borrower saveBorrower(Borrower borrower) {
        return repository.save(borrower);
    }

    public boolean deleteBorrowerById(int id){
        if(getBorrowerById(id) == null) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
