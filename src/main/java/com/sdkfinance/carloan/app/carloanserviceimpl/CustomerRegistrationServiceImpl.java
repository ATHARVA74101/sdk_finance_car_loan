package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanrepository.CustomerRegistrationRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.CustomerRegistrationServiceInterface;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationServiceInterface {

	@Autowired
	CustomerRegistrationRepository cRR;
	
	public CustomerDetails postCust(CustomerDetails cd) {
		CustomerDetails cust = this.cRR.save(cd);
		return cust;
	}

	public List<CustomerDetails> getAllApplicantDoc() {
		
		return cRR.findAll();
	}

	public CustomerDetails getSingleAppDoc(Integer id) {
		
		return cRR.findByCustomerid(id);
	}

	
	
}
