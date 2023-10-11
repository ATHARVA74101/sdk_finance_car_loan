package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.Empreg;
import com.sdkfinance.carloan.app.carloanmodel.Enquirydetails;
import com.sdkfinance.carloan.app.carloanrepository.EmpRegRepository;
import com.sdkfinance.carloan.app.carloanrepository.EnquiryDetailsRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.EnquiryDetailsInterface;

@Service
public class EnquiryDetailsInterfaceImpl implements EnquiryDetailsInterface{

	@Autowired
	EnquiryDetailsRepository edr;
	
	@Autowired
	EmpRegRepository err;
	
	@Override
	public Enquirydetails postEnquiry(Enquirydetails enq) {
		Enquirydetails ed = edr.save(enq);
		return ed;
	}

	@Override
	public List<Enquirydetails> getEnquiries() {
		
		return edr.findAll();
	}

	@Override
	public Empreg postReg(Empreg reg) {
		Empreg regist= err.save(reg);
		return regist;
	}

	@Override
	public List<Empreg> getEmp() {
		
		return err.findAll();
	}

	@Override
	public Enquirydetails getEnquiry(String userName) {	
		return edr.findByUserName(userName);
	}
}
