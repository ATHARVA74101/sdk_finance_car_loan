package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdkfinance.carloan.app.carloanmodel.Empreg;

public interface EmpRegRepository extends JpaRepository<Empreg, Integer>{

}
