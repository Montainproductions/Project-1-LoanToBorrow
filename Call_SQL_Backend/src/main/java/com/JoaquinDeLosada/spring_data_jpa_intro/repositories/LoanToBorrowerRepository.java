package com.JoaquinDeLosada.spring_data_jpa_intro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JoaquinDeLosada.spring_data_jpa_intro.models.LoanToBorrower;

@Repository
public interface LoanToBorrowerRepository extends JpaRepository<LoanToBorrower, Integer> {
    
}
