package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.CibilStatus;
import com.sdkfinance.carloan.app.carloanrepository.CibilServiceRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.CibilStatusInerface;

@Service
public class CibilStatusInterfaceImpl implements CibilStatusInerface {

	@Autowired
	CibilServiceRepository csr;
	
	public CibilStatus saveCibilStatus(CibilStatus cs) {
		
		return csr.save(cs);
	}

	public List<CibilStatus> getCibilStatus() {
		
		return csr.findAll();
	}

	
}
