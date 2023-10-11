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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.Emidetail;
import com.sdkfinance.carloan.app.carloanmodel.Offerletter;
import com.sdkfinance.carloan.app.carloanrepository.CustomerRegistrationRepository;
import com.sdkfinance.carloan.app.carloanserviceimpl.OfferLatterServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/offer")
public class OfferLatter {
	
	@Autowired
	OfferLatterServiceImpl os;
	
	@Autowired
	CustomerRegistrationRepository crr;
	
	//post data for Ledger
	
		@PostMapping(value = "/postoffer/{num}")
		public ResponseEntity<Offerletter> saveLedger(@PathVariable ("num") Integer num,@RequestBody Offerletter o) {
		CustomerDetails cd = crr.findByCustomerid(num);
		System.out.println("----------------------------Ujwal--------------------------------");
			System.out.println(o.getCurrentloanid());
			System.out.println(o.getLoanamount());
			o.setCurrentloanid(cd.getOfferletter().getCurrentloanid());
//			Emidetail e = new Emidetail();
//			e.setEmiid(cd.getOfferletter().getEmidetails().getEmiid());
			o.getEmidetails().setEmiid(cd.getOfferletter().getEmidetails().getEmiid());
		    cd.setOfferletter(o);
		    System.out.println("Hii"+cd.getOfferletter().getLoanamount());
//			Offerletter off=os.saveOfferletter(o);
		 
		    crr.saveAndFlush(cd);
		    
			return new ResponseEntity<Offerletter>(HttpStatus.OK);
		}
		
		//Get API
		@GetMapping(value = "/getoffer")
		public ResponseEntity<List<Offerletter>> getoffer(){
			List<Offerletter> off= os.getOffer();
			return new ResponseEntity<List<Offerletter>>(off,HttpStatus.OK);
		}
		//Get Single Data
		
		@GetMapping(value = "/getoffer/{currentloanid}")
		public ResponseEntity<Offerletter> getOffer(@PathVariable ("currentloanid")Integer currentloanid){
				
			Offerletter p=os.getOffer(currentloanid);
				
				return new ResponseEntity<Offerletter>(p,HttpStatus.OK);
		}

}
