package com.JoaquinDeLosada.spring_data_jpa_intro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Modifying
    @Transactional
    @Query("update Loan m set m.loanName = :loanName where id = :id")
    public String updateLoanTitle(@Param("id") int id, @Param("loanName") String loanName);
    
    @Modifying
    @Transactional
    @Query("update Loan u set u.loanType = :loanType where id = :id")
    public String updateLoadType(@Param("id") int id, @Param("loanType") String loanType);

    @Modifying
    @Transactional
    @Query("update Loan u set u.lengthOfLoanMonths = :lengthOfLoanMonths where id = :id")
    public int updateLengthOfLoan(@Param("id") int id, @Param("loanType") int loanType);

    @Modifying
    @Transactional
    @Query("update Loan u set u.loanCurrentMonth = :loanCurrentMonth where id = :id")
    public int updateCurrentMonth(
        @Param("id") int id, @Param("loanCurrentMonth") int loanCurrentMonth);

    @Modifying
    @Transactional
    @Query("update Loan u set u.initialLoanAmount = :initialLoanAmount where id = :id")
    public int updateInitialLoanAmount(
        @Param("id") int id, @Param("initialLoanAmount") int initialLoanAmount);

    @Modifying
    @Transactional
    @Query("update Loan m set m.currentInterestRate = :currentInterestRate where id = :id")
    public String updateCurrentInterestRate(
        @Param("id") int id, @Param("currentInterestRate") float loanName);
    
    @Modifying
    @Transactional
    @Query("update Loan u set u.isAdjustableRate = :isAdjustableRate where id = :id")
    public String updateIsAdjustableRate(
        @Param("id") int id, @Param("isAdjustableRate") boolean isAdjustableRate);

    @Modifying
    @Transactional
    @Query("update Loan u set u.initialInterestRate = :initialInterestRate where id = :id")
    public int updateInitialInterestRate(@Param("id") int id, @Param("initialInterestRate") float initialInterestRate);

    @Modifying
    @Transactional
    @Query("update Loan u set u.adjustedInterestRate = :adjustedInterestRate where id = :id")
    public int updateAdjustedInterestRate(
        @Param("id") int id, @Param("adjustedInterestRate") float adjustedInterestRate);

    @Modifying
    @Transactional
    @Query("update Loan u set u.monthAtInterestRateChange = :monthAtInterestRateChange where id = :id")
    public int updateMonthAtInterestRateChange(@Param("id") int id, @Param("monthAtInterestRateChange") int monthAtInterestRateChange);

    @Modifying
    @Transactional
    @Query("update Loan m set m.loanAmountRemaining = :loanAmountRemaining where id = :id")
    public String updateLoanAmountRemaining(
        @Param("loan-id") int id, @Param("loanAmountRemaining") float loanAmountRemaining);
    
    @Modifying
    @Transactional
    @Query("update Loan u set u.downpaymentAmount = :downpaymentAmount where id = :id")
    public String updateDownpaymentAmount(
        @Param("id") int id, @Param("downpaymentAmount") float downpaymentAmount);

    @Modifying
    @Transactional
    @Query("update Loan u set u.amountOfMissedPayments = :amountOfMissedPayments where id = :id")
    public int updateAmountOfMissedPayments(
        @Param("id") int id, @Param("amountOfMissedPayments") float amountOfMissedPayments);

    @Modifying
    @Transactional
    @Query("update Loan u set u.paymentDate = :paymentDate where id = :id")
    public int updatePaymentDate(@Param("id") int id, @Param("paymentDate") String paymentDate);
}
