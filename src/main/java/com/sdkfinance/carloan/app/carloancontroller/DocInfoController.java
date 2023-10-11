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

import com.sdkfinance.carloan.app.carloanmodel.DocInfo;
import com.sdkfinance.carloan.app.carloanserviceimpl.DocInfoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/doc")
public class DocInfoController {
	
	@Autowired
	DocInfoServiceImpl disi;
	
	@PostMapping("/saveDocInfo")
	public ResponseEntity<DocInfo> saveDocInfo(@RequestBody DocInfo di){
		DocInfo saveDocInfo = this.disi.saveDocInfo(di);
		
		return new ResponseEntity<DocInfo>(saveDocInfo,HttpStatus.CREATED);
	}
	
	@GetMapping("/getDoc/{id}")
	public ResponseEntity<DocInfo> getDocInfo(@PathVariable ("id") Integer id){
		DocInfo docInfo = this.disi.getDocInfo(id);
		
		return new ResponseEntity<>(docInfo, HttpStatus.OK);
	}

	@GetMapping("/getDocList")
	public ResponseEntity<List< DocInfo>> getDocInfolist(){
		List<DocInfo> docInfo = this.disi.getDocInfolist();	
		return new ResponseEntity<List<DocInfo>>(docInfo, HttpStatus.OK);
	}   
}
