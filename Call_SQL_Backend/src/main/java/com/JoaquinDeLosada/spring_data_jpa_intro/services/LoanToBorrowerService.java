package com.JoaquinDeLosada.spring_data_jpa_intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.Loan;
import com.JoaquinDeLosada.spring_data_jpa_intro.models.LoanToBorrower;
import com.JoaquinDeLosada.spring_data_jpa_intro.repositories.LoanRepository;
import com.JoaquinDeLosada.spring_data_jpa_intro.repositories.LoanToBorrowerRepository;

@Service
public class LoanToBorrowerService {

    private final LoanToBorrowerRepository loanToBorrowerRepository;

    public LoanToBorrowerService(LoanToBorrowerRepository loanToBorrowerRepository) {
        this.loanToBorrowerRepository = loanToBorrowerRepository;
    }

    public List<LoanToBorrower> getAllLoansToBorrowers(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<LoanToBorrower> loanToBorrowerPage = loanToBorrowerRepository.findAll(pageable);
        List<LoanToBorrower> loanToBorrowerList = loanToBorrowerPage.getContent();

        return loanToBorrowerList;
    }

    public LoanToBorrower getLoanToBorrowerById(int id) {

        if(id < 0) {
            return (LoanToBorrower)loanToBorrowerRepository.findAll(); //if no id given then return all.
        }
        
        Optional<LoanToBorrower> loan = loanToBorrowerRepository.findById(id);
        
        if(loan.isPresent()) {
            return loan.get();
        }

        // no loan found
        return null;
    }


    @Transactional
    public LoanToBorrower saveLoanToBorrower(LoanToBorrower loan) {
        return loanToBorrowerRepository.save(loan);
    }

    @Transactional
    public boolean deleteLoanToBorrower(int id) {
        if(getLoanToBorrowerById(id) == null) {
            return false;
        }

        loanToBorrowerRepository.deleteById(id);
        return true;
    }
}
