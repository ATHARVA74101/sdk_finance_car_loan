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

import com.sdkfinance.carloan.app.carloanmodel.CibilStatus;
import com.sdkfinance.carloan.app.carloanserviceimpl.CibilStatusInterfaceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/cibil")
public class CibilStatusController {
	

	@Autowired
	CibilStatusInterfaceImpl csi;

	@PostMapping(value="/cibilstatus")
	public ResponseEntity<CibilStatus> saveCibilStatus(@RequestBody CibilStatus cs)
	{
		CibilStatus cse=csi.saveCibilStatus(cs);
		return new ResponseEntity<CibilStatus>(cse,HttpStatus.CREATED);
	}
	@GetMapping(value="/cibilstatus")
	public ResponseEntity<List<CibilStatus>> getCibilStatus()
	{
		List<CibilStatus> cse=csi.getCibilStatus();
		return new ResponseEntity<List<CibilStatus>>(cse,HttpStatus.OK);
	}
}







