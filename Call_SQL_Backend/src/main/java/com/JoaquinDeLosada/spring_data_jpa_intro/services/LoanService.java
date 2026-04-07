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
import com.JoaquinDeLosada.spring_data_jpa_intro.repositories.LoanRepository;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Loan> loanPage = loanRepository.findAll(pageable);
        List<Loan> loanList = loanPage.getContent();

        return loanList;
    }

    public Loan getLoanById(int id) {

        if(id < 0) {
            return (Loan)loanRepository.findAll(); //if no id given then return all.
        }
        
        Optional<Loan> loan = loanRepository.findById(id);
        
        if(loan.isPresent()) {
            return loan.get();
        }

        // no loan found
        return null;
    }


    @Transactional
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Transactional
    public boolean deleteLoan(int id) {
        if(getLoanById(id) == null) {
            return false;
        }

        loanRepository.deleteById(id);
        return true;
    }

    /* Actual Buisness logic */

    public float AmountMonthlyPayment(int id){
        Loan loanToCalculate = getLoanById(id);
        float monthsLeft = loanToCalculate.getLengthOfLoanMonths() - loanToCalculate.getLoanCurrentMonth();
        float payment = 
            loanToCalculate.getloanAmountRemaining()*((loanToCalculate.getCurrentInterestRate() * 
            InterestpaymentCalculation(loanToCalculate.getCurrentInterestRate(), monthsLeft))) /
            (InterestpaymentCalculation(loanToCalculate.getCurrentInterestRate(), monthsLeft)-1);
        return payment;
    }

    public float InterestpaymentCalculation(float interestRate, float paymentsLeft){
        return (float)Math.pow(1+interestRate, paymentsLeft);
    }


}
