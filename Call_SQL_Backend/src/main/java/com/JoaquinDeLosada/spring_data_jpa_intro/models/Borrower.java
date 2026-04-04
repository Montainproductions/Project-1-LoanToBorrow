package com.JoaquinDeLosada.spring_data_jpa_intro.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Borrower")
public class Borrower {

    //@OneToMany(targetEntity = otherControllerName.class, mappedBy = "classname")
    @Id                                                     
    @Column                                                 
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private int id;

    @NotBlank
    @Column(name = "first_name")
    private String borrowerFirstName;

    @NotBlank
    @Column(name = "last_name")
    private String borrowerLastName;

    @Column(name = "employmentType")
    private int employmentType;

    //@Min(value = 300)
    //@Max(value = 850)
    @Column(name = "creditScore")
    private int creditScore;

    @Column(name = "email")
    private String email;

    //@Min(value = 0000000000)
    @Size
    //@Max(value = 9999999999)
    @Column(name = "mainPhone")
    private String mainPhone;

    @Column(name = "borrowerAddress")
    private String address;

    //@Min(value = 1)
    //@Max(value = 10)
    @Column(name = "zipCode")
    private int zipCode;
    
    //@Min(value = 1)
    //@Max(value = 10)
    @Column(name = "usState")
    private int state;

    @Column(name = "ssnFourDigits")
    private int ssnFourDigits;

    @Column(name = "incomeMonthly")
    private float monthlyIncome;

    @Column(name = "incomeYearly")
    private float yearlyIncome;
    
    public Borrower() {

    }

    public Borrower(int id, String borrowerFirstName, String lastName, int employmentType, 
        int creditScore, String email, String mainPhone, String address, int zipCode, int state, 
        int ssnFourDigits, float monthlyIncome, float yearlyIncome) {
        this.id = id;
        this.borrowerFirstName = borrowerFirstName;
        this.borrowerLastName = lastName;
        this.employmentType = employmentType;
        this.creditScore = creditScore;
        this.email = email;
        this.mainPhone = mainPhone;
        this.address = address;
        this.zipCode = zipCode;
        this.state = state;
        this.ssnFourDigits = ssnFourDigits;
        this.monthlyIncome = monthlyIncome;
        this.yearlyIncome = yearlyIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return borrowerFirstName;
    }

    public void setFirstName(String borrowerFirstName) {
        this.borrowerFirstName = borrowerFirstName;
    }

    public String getBorrowerLastName() {
        return borrowerLastName;
    }

    public void setBorrowerLastName(String borrowerLastName) {
        this.borrowerLastName = borrowerLastName;
    }

    public int getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(int employmentType) {
        this.employmentType = employmentType;
    }

    public int getCreditScore(){
        return creditScore;
    }

    public void setCreditScore(int creditScore){
        this.creditScore = creditScore;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return mainPhone;
    }

    public void setPhone(String mainPhone){
        this.mainPhone = mainPhone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getZipCode(){
        return zipCode;
    }

    public void setZipCode(int zipCode){
        this.zipCode = zipCode;
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }

    public int getSSNFourDigits(){
        return ssnFourDigits;
    }

    public void setSSNFourDigits(int ssnFourDigits){
        this.ssnFourDigits = ssnFourDigits;
    }

    public float getMonthlyIncome(){
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome){
        this.monthlyIncome = monthlyIncome;
    }

    public float getYearlyIncome(){
        return yearlyIncome;
    }

    public void setYearlyIncome(float yearlyIncome){
        this.yearlyIncome = yearlyIncome;
    }
}
