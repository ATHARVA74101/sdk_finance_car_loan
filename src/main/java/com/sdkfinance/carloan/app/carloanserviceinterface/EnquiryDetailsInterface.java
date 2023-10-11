package com.sdkfinance.carloan.app.carloanserviceinterface;

import java.util.List;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.Empreg;
import com.sdkfinance.carloan.app.carloanmodel.Enquirydetails;

public interface EnquiryDetailsInterface {

	Enquirydetails postEnquiry(Enquirydetails enq);

	List<Enquirydetails> getEnquiries();

	Empreg postReg(Empreg reg);

	List<Empreg> getEmp();

	Enquirydetails getEnquiry(String userName);


}
