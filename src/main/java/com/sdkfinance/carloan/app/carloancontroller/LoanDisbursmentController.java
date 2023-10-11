package com.sdkfinance.carloan.app.carloancontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.Loandisbursment;
import com.sdkfinance.carloan.app.carloanrepository.CustomerRegistrationRepository;
import com.sdkfinance.carloan.app.carloanrepository.LoanDisbursmentRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/loandis")
public class LoanDisbursmentController {
	
	@Autowired
	LoanDisbursmentRepository ldr;
	
	@Autowired
	CustomerRegistrationRepository crr;
	
	@PostMapping(value="/saveloanData/{id}")
	public ResponseEntity<Loandisbursment> saveLoan(@PathVariable("id") Integer id,@RequestBody Loandisbursment ld)
	{
		CustomerDetails cd = crr.findByCustomerid(id);
		System.out.println("-----------------Ujwal----------------------------------");
	   Integer loandisid = cd.getLoandisbursment().getLoandisid();
	   ld.setLoandisid(cd.getLoandisbursment().getLoandisid());
	   cd.setLoandisbursment(ld);
	   crr.save(cd);
//		Loandisbursment dis= ldr.save(ld);
		return new ResponseEntity<Loandisbursment>(HttpStatus.CREATED);
	}

}
