package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sdkfinance.carloan.app.carloanmodel.Enquirydetails;

@Repository
public interface EnquiryDetailsRepository extends JpaRepository<Enquirydetails, Integer>{

	Enquirydetails findByUserName(String userName);
}
