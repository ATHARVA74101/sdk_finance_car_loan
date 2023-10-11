package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.Offerletter;
import com.sdkfinance.carloan.app.carloanrepository.OfferRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.OfferLatterInterface;

@Service
public class OfferLatterServiceImpl implements OfferLatterInterface {
	
	@Autowired
	OfferRepository of;

	@Override
	public Offerletter saveOfferletter(Offerletter o) {
		return of.save(o);
	}

	@Override
	public List<Offerletter> getOffer() {
		return of.findAll();
	}

	@Override
	public Offerletter getOffer(Integer currentloanid) {
		return of.findByCurrentloanid(currentloanid);
	}

}
