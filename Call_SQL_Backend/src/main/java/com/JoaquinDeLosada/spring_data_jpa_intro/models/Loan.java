package com.JoaquinDeLosada.spring_data_jpa_intro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Loan {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "loanName")
    private String loanName;

    @Column(name = "loanType")
    private String loanType;

    @Column(name = "lenghtOfLoanMonths")
    private int lengthOfLoanMonths;

    @Column(name = "currentMonth")
    private int loanCurrentMonth;

    @Column(name = "initialLoanAmount")
    private int initialLoanAmount;
    
    @Column(name = "currentInterestRate")
    private float currentInterestRate;

    @Column(name = "isAdjustableRate")
    private boolean isAdjustableRate;

    @Column(name = "initialInterestRate")
    private float initialInterestRate;

    @Column(name = "adjustedInterestRate")
    private float adjustedInterestRate;

    @Column(name = "monthAtInterestRateChange")
    private int monthAtInterestRateChange;

    @Column(name = "loanAmountRemaining")
    private float loanAmountRemaining; //A bit iffy on if this is needed or I can find a way to quickly calculate it.

    @Column(name = "downpaymentAmount")
    private float downpaymentAmount;

    @Column(name = "amountOfMissedPayments")
    private int amountOfMissedPayments;

    @Column(name = "paymentDate")
    private String paymentDate;

    public Loan() {
    }

    public Loan(int id, String loanName, String loanType, int lengthOfLoanMonths, int loanCurrentMonth,
        int initialLoanAmount, float currentInterestRate, boolean isAdjustableRate, float initialInterestRate,
        float adjustedInterestRate, int monthAtInterestRateChange, float loanAmountRemaining, 
        float downpaymentAmount, int amountOfMissedPayments, String paymentDate) {
        this.id = id;
        this.loanName = loanName;
        this.loanType = loanType;
        this.lengthOfLoanMonths = lengthOfLoanMonths;
        this.loanCurrentMonth = loanCurrentMonth;
        this.initialLoanAmount = initialLoanAmount;
        this.currentInterestRate = currentInterestRate;
        this.isAdjustableRate = isAdjustableRate;
        this.initialInterestRate = initialInterestRate;
        this.adjustedInterestRate = adjustedInterestRate;
        this.monthAtInterestRateChange = monthAtInterestRateChange;
        this.loanAmountRemaining = loanAmountRemaining;
        this.downpaymentAmount = downpaymentAmount;
        this.amountOfMissedPayments = amountOfMissedPayments;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getLengthOfLoanMonths() {
        return lengthOfLoanMonths;
    }

    public void setGenre(int lengthOfLoanMonths) {
        this.lengthOfLoanMonths = lengthOfLoanMonths;
    }

    public int getLoanCurrentMonth() {
        return loanCurrentMonth;
    }

    public void setLoanCurrentMonth(int loanCurrentMonth) {
        this.loanCurrentMonth = loanCurrentMonth;
    }

    public int getInitialLoanAmount() {
        return initialLoanAmount;
    }

    public void setInitialLoanAmount(int initialLoanAmount) {
        this.initialLoanAmount = initialLoanAmount;
    }

    public float getCurrentInterestRate() {
        return currentInterestRate;
    }

    public void setcurrentInterestRate(float currentInterestRate) {
        this.currentInterestRate = currentInterestRate;
    }

    public boolean getIsAdjustableRate() {
        return isAdjustableRate;
    }

    public void setIsAdjustableRate(boolean isAdjustableRate) {
        this.isAdjustableRate = isAdjustableRate;
    }

    public float getInitialInterestRate() {
        return initialInterestRate;
    }

    public void setinitialInterestRate(float initialInterestRate) {
        this.initialInterestRate = initialInterestRate;
    }

    public float getadjustedInterestRate() {
        return adjustedInterestRate;
    }

    public void setLoanCurrentMonth(float adjustedInterestRate) {
        this.adjustedInterestRate = adjustedInterestRate;
    }
        public int getMonthAtInterestRateChange() {
        return monthAtInterestRateChange;
    }

    public void setMonthAtInterestRateChange(int monthAtInterestRateChange) {
        this.monthAtInterestRateChange = monthAtInterestRateChange;
    }

    public float getloanAmountRemaining() {
        return loanAmountRemaining;
    }

    public void setLoanAmountRemaining(float loanAmountRemaining) {
        this.loanAmountRemaining = loanAmountRemaining;
    }

    public float getDownpaymentAmount() {
        return downpaymentAmount;
    }

    public void setDownpaymentAmount(float downpaymentAmount) {
        this.downpaymentAmount = downpaymentAmount;
    }

    public int getamountOfMissedPayments() {
        return amountOfMissedPayments;
    }

    public void setAmountOfMissedPayments(int amountOfMissedPayments) {
        this.amountOfMissedPayments = amountOfMissedPayments;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
