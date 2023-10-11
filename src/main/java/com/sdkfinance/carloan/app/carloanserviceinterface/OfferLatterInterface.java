package com.sdkfinance.carloan.app.carloanserviceinterface;

import java.util.List;
import com.sdkfinance.carloan.app.carloanmodel.Offerletter;


public interface OfferLatterInterface {
	
	public Offerletter saveOfferletter(Offerletter o); 
	public List<Offerletter> getOffer();
	public Offerletter getOffer(Integer currentloanid);

}
