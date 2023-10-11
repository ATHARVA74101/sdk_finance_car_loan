package com.sdkfinance.carloan.app.carloanserviceinterface;

import java.util.List;
import com.sdkfinance.carloan.app.carloanmodel.Cibil;


public interface CibilServiceInterface {
	
	public Cibil saveCibil(Cibil c); 
	public List<Cibil> getCibil();

}
