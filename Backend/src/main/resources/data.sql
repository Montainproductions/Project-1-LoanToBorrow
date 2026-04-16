/*

    used by the h2 database duing application startup

    populates table with data
    
*/

/* make sure to insert Loan first */
insert into Loan (loanName, loanType, lengthOfLoanMonths, loanCurrentMonth, initialLoanAmount, 
currentInterestRate, isAdjustableRate, initialInterestRate, adjustedInterestRate, monthAtInterestRateChange, 
loanAmountRemaining, downpaymentAmount, amountOfMissedPayments, paymentDate) 
values ('autoLoan1', 'AutoLoan', 60, 3, 60000, 5, false, 5, 5,0,0,0,0,"05");

insert into Loan (loanName, loanType, lengthOfLoanMonths, loanCurrentMonth, initialLoanAmount, 
currentInterestRate, isAdjustableRate, initialInterestRate, adjustedInterestRate, monthAtInterestRateChange, 
loanAmountRemaining, downpaymentAmount, amountOfMissedPayments, paymentDate) 
values ('autoLoan1', 'AutoLoan', 60, 3, 60000, 5, false, 5, 5,0,0,0,0,"05");

insert into Borrower (firstName, lastName, employmentType, creditScore, email, mainPhone, borrowerAddress, zipCode, usState, ssnFourDigits, monthlyIncome, yearlyIncome) values ('Friend Zone (Pagafantas)', 2, 'ROMANCE', 2);

