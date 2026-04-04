drop table if exists Loan;
drop table if exists Borrower;
drop table if exists LoansToApprove;

create table Loan (
	id INT AUTO_INCREMENT PRIMARY KEY,
	loanName TEXT,
	loanType TEXT,
	lengthOfLoanMonths INT,
	loanCurrentMonth INT,
	initialLoanAmount FLOAT,
	currentInterestRate FLOAT,
	isAdjustableRate BOOLEAN,
	initialInterestRate FLOAT,
	adjustedInterestRate FLOAT,
	monthAtInterestRateChange INT,
	loanAmountRemaining FLOAT,
	downpaymentAmount FLOAT,
	amountOfMissedPayments INT,
	paymentDate TEXT
);

create table Borrower (
	id INT AUTO_INCREMENT PRIMARY KEY,
	firstName TEXT,
	lastName TEXT,
	employmentType INT,
	creditScore INT,
	email TEXT,
	mainPhone INT,
	borrowerAddress TEXT,
	zipCode INT,
	usState INT,
	ssnFourDigits INT,
	monthlyIncome FLOAT,
	yearlyIncome FLOAT
);

CREATE Table LoansToApprove(
	id INT AUTO_INCREMENT PRIMARY KEY,
	//borrower Borrower,
	//loan Loan
	loanAmount FLOAT,

);