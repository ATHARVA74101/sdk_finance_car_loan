package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerDetails, Integer> {
	
	public CustomerDetails findByCustomerid(Integer id);
}
