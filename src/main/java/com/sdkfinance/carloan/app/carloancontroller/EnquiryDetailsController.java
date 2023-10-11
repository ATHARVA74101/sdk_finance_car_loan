package com.sdkfinance.carloan.app.carloancontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.Empreg;
import com.sdkfinance.carloan.app.carloanmodel.Enquirydetails;
import com.sdkfinance.carloan.app.carloanserviceinterface.EnquiryDetailsInterface;

@CrossOrigin("*")
@RestController
public class EnquiryDetailsController {

	@Autowired
	EnquiryDetailsInterface edi;
	
	//Customer Enquiry Save
	@PostMapping(value="/enquiry")
	public ResponseEntity<Enquirydetails> postEnquiry(@RequestBody Enquirydetails enq)
	{
		Enquirydetails ed =edi.postEnquiry(enq);
		return new ResponseEntity<Enquirydetails>(enq,HttpStatus.CREATED);
	}
	//Customer Enquiry Retrive for Login
	@GetMapping(value="/enquiries")
	public ResponseEntity<List<Enquirydetails>> getEnquiries()
	{
		List<Enquirydetails>list=edi.getEnquiries();
		if(list.isEmpty())
		{
			return new ResponseEntity<List<Enquirydetails>>(HttpStatus.NO_CONTENT);
		}
		else 
		{
			return new ResponseEntity<List<Enquirydetails>>(list,HttpStatus.OK);
		}
	}
	@PostMapping(value="/empreg")
	public ResponseEntity<Empreg> postReg(@RequestBody Empreg reg)
	{
		Empreg ed =edi.postReg(reg);
		return new ResponseEntity<Empreg>(reg,HttpStatus.CREATED);
	}
	//Employee Retrive for Login
		@GetMapping(value="/empreg")
		public ResponseEntity<List<Empreg>> getEmp()
		{
			List<Empreg>list=edi.getEmp();
			if(list.isEmpty())
			{
				return new ResponseEntity<List<Empreg>>(HttpStatus.NO_CONTENT);
			}
			else 
			{
				return new ResponseEntity<List<Empreg>>(list,HttpStatus.OK);
			}
		}
		
		//Get Single Customer
		
		@GetMapping(value="/singlecustomer/{userName}")
		public ResponseEntity<Enquirydetails> getEnquiry(@PathVariable String userName)
		{
			Enquirydetails list=edi.getEnquiry(userName);
//			if(list.isEmpty())
//			{
//				return new ResponseEntity<Enquirydetails>(HttpStatus.NO_CONTENT);
//			}
//			else 
			{
				return new ResponseEntity<Enquirydetails>(list,HttpStatus.OK);
			}
		}	
		
}
