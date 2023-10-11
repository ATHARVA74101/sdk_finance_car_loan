package com.sdkfinance.carloan.app.carloancontroller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdkfinance.carloan.app.carloanmodel.Cibil;

import com.sdkfinance.carloan.app.carloanserviceimpl.CibilServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/cibilScore")
public class CibilController {

	@Autowired
	CibilServiceImpl cs;

	// post data cibil
	@GetMapping(value = "/cibil/{pan}")
	public ResponseEntity<Integer> saveCibil(@PathVariable("pan") String pan) {

		Cibil cib = new Cibil();
		cib.setPannumber(pan);

		System.out.println("saveCibil()" + cib);

		Random r = new Random();
		int ci = r.nextInt(1000);

		Integer c3 = 650;
		if (ci >= 650) {
			cib.setCibilscore(ci);
			c3 = ci;
			System.out.println(cib);
		} else {

			System.out.println("Try again...");

		}

		return new ResponseEntity<Integer>(c3, HttpStatus.OK);
	}

	// post data for Ledger

//	@PostMapping(value = "/ledger")
//	public ResponseEntity<Ledger> saveLedger(@RequestBody Ledger l) {
//		Ledger led=ls.saveLedger(l);
//		return new ResponseEntity<Ledger>(led,HttpStatus.OK);
//	}

	// Get API
//		@GetMapping(value = "/ledgers")
//		public ResponseEntity<List<Ledger>> getLedgerdata(){
//			List<Ledger> led= ls.getLedgerdata();
//			return new ResponseEntity<List<Ledger>>(led,HttpStatus.OK);
//		}

}
