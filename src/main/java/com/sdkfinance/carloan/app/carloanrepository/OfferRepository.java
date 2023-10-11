package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdkfinance.carloan.app.carloanmodel.Offerletter;

@Repository
public interface OfferRepository extends JpaRepository<Offerletter, Integer> {
	
	public Offerletter findByCurrentloanid(Integer currentloanid);

}
