package com.sdkfinance.carloan.app.carloanserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.DocInfo;
import com.sdkfinance.carloan.app.carloanrepository.DocInfoRepository;

@Service
public class DocInfoServiceImpl {
	
	@Autowired
	DocInfoRepository dIR;
	
	public DocInfo saveDocInfo(DocInfo di) {
		return this.dIR.save(di);
	}

	public DocInfo getDocInfo(Integer id) {
		return this.dIR.findByCustId(id);
		
	}

	public List<DocInfo> getDocInfolist() {
		
		return this.dIR.findAll();
	}

}
