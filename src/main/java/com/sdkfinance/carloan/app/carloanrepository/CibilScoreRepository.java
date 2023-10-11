package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdkfinance.carloan.app.carloanmodel.Cibil;


@Repository
public interface CibilScoreRepository extends JpaRepository<Cibil,Integer> {

}
