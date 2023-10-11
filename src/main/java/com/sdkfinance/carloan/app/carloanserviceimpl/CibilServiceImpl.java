package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.Cibil;
import com.sdkfinance.carloan.app.carloanrepository.CibilScoreRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.CibilServiceInterface;

@Service
public class CibilServiceImpl implements CibilServiceInterface{
	
	@Autowired
	CibilScoreRepository cr;

	@Override
	public Cibil saveCibil(Cibil c) {
		return cr.save(c);
	}

	@Override
	public List<Cibil> getCibil() {
		return cr.findAll();
	}

}
