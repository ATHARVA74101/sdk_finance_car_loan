package com.sdkfinance.carloan.app.carloancontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdkfinance.carloan.app.carloanmodel.Cibil;
import com.sdkfinance.carloan.app.carloanmodel.Currentaddress;
import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.Dealeraccountdetails;
import com.sdkfinance.carloan.app.carloanmodel.Documents;
import com.sdkfinance.carloan.app.carloanmodel.Emidetail;
import com.sdkfinance.carloan.app.carloanmodel.Guarantordetail;
import com.sdkfinance.carloan.app.carloanmodel.Ledger;
import com.sdkfinance.carloan.app.carloanmodel.Loandisbursment;
import com.sdkfinance.carloan.app.carloanmodel.Mortagagedetail;
import com.sdkfinance.carloan.app.carloanmodel.Occupation;
import com.sdkfinance.carloan.app.carloanmodel.Offerletter;
import com.sdkfinance.carloan.app.carloanmodel.Permentaddress;
import com.sdkfinance.carloan.app.carloanmodel.Previousbankloandetails;
import com.sdkfinance.carloan.app.carloanmodel.Previousloan;
import com.sdkfinance.carloan.app.carloanmodel.Sanctionletter;
import com.sdkfinance.carloan.app.carloanserviceimpl.CustomerRegistrationServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/reg")
public class CustomerRegistrationController {
	
	@Autowired
	CustomerRegistrationServiceImpl cRS;
	
	@PostMapping(value="/saveCustomer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<CustomerDetails> saveCustomer(
			@RequestPart(value="occupation.salrySlip")MultipartFile salarySlip,
			@RequestPart(value="documents.addharcard")MultipartFile adhaarCard,
			@RequestPart(value="documents.pancard")MultipartFile panCard,
			@RequestPart(value="documents.lastthreeyearITR")MultipartFile lastThreeYearsItr,
			@RequestPart(value="documents.photo")MultipartFile photo,
			@RequestPart(value="documents.bankcheque")MultipartFile bankcheque,
			@RequestPart(value="documents.signature")MultipartFile signature,
			@RequestPart(value="mortagagedetail.mortgagepropertyproof")MultipartFile morgageProof,
			@RequestPart(value="data") String data
			) throws IOException {
		CustomerDetails cd=new CustomerDetails();
		
		Occupation oc =new Occupation();
		Documents doc=new Documents(); 
		Currentaddress curAdd=new Currentaddress();
		Permentaddress perAdd=new Permentaddress();
		Mortagagedetail morg=new Mortagagedetail();
		
		Previousloan preLoan=new Previousloan();
		Previousbankloandetails preLoanDetails=new Previousbankloandetails();
		
		Dealeraccountdetails dealer=new Dealeraccountdetails();
		Guarantordetail guarantor=new Guarantordetail();
		Cibil cib=new Cibil();
		
		Offerletter offerLetter=new Offerletter();
		Emidetail emi=new Emidetail();
		
		Sanctionletter sacLetter=new Sanctionletter();
		Ledger led=new Ledger();
		Loandisbursment lDisburs=new Loandisbursment();
		
		//Setting All Documents
		oc.setSalrySlip(salarySlip.getBytes());
		doc.setAddharcard(adhaarCard.getBytes());
		doc.setPancard(panCard.getBytes());
		doc.setLastthreeyearITR(lastThreeYearsItr.getBytes());
		doc.setPhoto(photo.getBytes());
		doc.setBankcheque(bankcheque.getBytes());
		doc.setSignature(signature.getBytes());
		morg.setMortgagepropertyproof(morgageProof.getBytes());
		
		ObjectMapper o =new ObjectMapper();
		o.enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature());
		
		CustomerDetails c=o.readValue(data, CustomerDetails.class);
		
		//Setting rest of All data controls 

		//Setting Basic Information
		cd.setCustomerfirstname(c.getCustomerfirstname());
		cd.setCustomermiddlename(c.getCustomermiddlename());
		cd.setCustomerlastname(c.getCustomerlastname());
		cd.setCustomerdob(c.getCustomerdob());
		cd.setCustomergender(c.getCustomergender());
		cd.setCustomeremail(c.getCustomeremail());
		cd.setCustomermobilenumber(c.getCustomermobilenumber());
		cd.setCustomeradditionalmobilenumber(c.getCustomeradditionalmobilenumber());
		
		//setting Requirement of Loan
		cd.setCustomeramountpaidforcar(c.getCustomeramountpaidforcar());
		cd.setCustomertotalloanrequired(c.getCustomertotalloanrequired());
		
		//Setting Current Address
		System.out.println("---------------------------------------------Prajwal---------------------------------");
		System.out.println(c.getCurrentaddress().getHousenumber());
		curAdd.setHousenumber(c.getCurrentaddress().getHousenumber());
		curAdd.setStreetname(c.getCurrentaddress().getStreetname());
		curAdd.setAreaname(c.getCurrentaddress().getAreaname());
		curAdd.setCityname(c.getCurrentaddress().getCityname());
		curAdd.setState(c.getCurrentaddress().getState());
		curAdd.setDistrict(c.getCurrentaddress().getDistrict());
		curAdd.setPincode(c.getCurrentaddress().getPincode());
		
		cd.setCurrentaddress(curAdd);
		

		//Setting Permnet Address
		perAdd.setHousenumber(c.getPermentaddress().getHousenumber());
		perAdd.setStreetname(c.getPermentaddress().getStreetname());
		perAdd.setAreaname(c.getPermentaddress().getAreaname());
		perAdd.setCityname(c.getPermentaddress().getCityname());
		perAdd.setState(c.getPermentaddress().getState());
		perAdd.setDistrict(c.getPermentaddress().getDistrict());
		perAdd.setPincode(c.getPermentaddress().getPincode());
		
		cd.setPermentaddress(perAdd);
		//Occupation Details
		oc.setOccupationtype(c.getOccupation().getOccupationtype());
		oc.setSalary(c.getOccupation().getSalary());
		oc.setRemainingWorkingPeriod(c.getOccupation().getRemainingWorkingPeriod());
		oc.setDesignation(c.getOccupation().getDesignation());
		
		cd.setOccupation(oc);
		
		//Setting Document
		doc.setQualification(c.getDocuments().getQualification());
		
		cd.setDocuments(doc);
		
		
		//Setting Mortgage Details
		morg.setMortgageloanonproperty(c.getMortagagedetail().getMortgageloanonproperty());
		morg.setMortgagepropertytype(c.getMortagagedetail().getMortgagepropertytype());
		morg.setMortgagepropertyvalue(c.getMortagagedetail().getMortgagepropertyvalue());
		
		cd.setMortagagedetail(morg);
		//Setting Previous Loan Details
			
			//Setting Previous Bank Details
		preLoanDetails.setBranchname(c.getPreviousloan().getPreviousbankloandetails().getBranchname());
		preLoanDetails.setBranchcode(c.getPreviousloan().getPreviousbankloandetails().getBranchcode());
		preLoanDetails.setBranchtype(c.getPreviousloan().getPreviousbankloandetails().getBranchtype());
		preLoanDetails.setIfsccode(c.getPreviousloan().getPreviousbankloandetails().getIfsccode());
		preLoanDetails.setMicrcode(c.getPreviousloan().getPreviousbankloandetails().getMicrcode());
		preLoanDetails.setConatctnumber(c.getPreviousloan().getPreviousbankloandetails().getConatctnumber());
		preLoanDetails.setBankaddress(c.getPreviousloan().getPreviousbankloandetails().getBankaddress());
		preLoanDetails.setEmail(c.getPreviousloan().getPreviousbankloandetails().getEmail());
		
		preLoan.setPreviousbankloandetails(preLoanDetails);
		preLoan.setPreviousLoanamount(c.getPreviousloan().getPreviousLoanamount());
		preLoan.setPreviousloantenure(c.getPreviousloan().getPreviousloantenure());
		preLoan.setPreviousloanpaidamount(c.getPreviousloan().getPreviousloanpaidamount());
		preLoan.setPreviousloanremainingamount(c.getPreviousloan().getPreviousloanremainingamount());
		preLoan.setPreviousloanstatus(c.getPreviousloan().getPreviousloanstatus());
		
		cd.setPreviousloan(preLoan);
		
		//Setting CIBIL Score
		cib.setPannumber(c.getCibil().getPannumber());
		cib.setCibilscore(c.getCibil().getCibilscore());
		cib.setCibilscoredatetime(c.getCibil().getCibilscoredatetime());
		cib.setStatus(c.getCibil().getStatus());
		cib.setRemark(c.getCibil().getRemark());
		
		cd.setCibil(cib);
		
		//Setting Gaurantor's Details
		guarantor.setGuarantorname(c.getGuarantordetail().getGuarantorname());
		guarantor.setProfession(c.getGuarantordetail().getProfession());
		guarantor.setRelationwithclient(c.getGuarantordetail().getRelationwithclient());
		guarantor.setMobileno(c.getGuarantordetail().getMobileno());
		guarantor.setAddress(c.getGuarantordetail().getAddress());
		guarantor.setPincode(c.getGuarantordetail().getPincode());
		guarantor.setCity(c.getGuarantordetail().getCity());
		guarantor.setDistrict(c.getGuarantordetail().getDistrict());
		guarantor.setState(c.getGuarantordetail().getState());
		guarantor.setCountry(c.getGuarantordetail().getCountry());
		guarantor.setAadharno(c.getGuarantordetail().getAadharno());
		guarantor.setPanno(c.getGuarantordetail().getPanno());
		
		cd.setGuarantordetail(guarantor);
		// Setiing Dealer's Details
		
		dealer.setAccountholdername(c.getDealeraccountdetails().getAccountholdername());
		dealer.setAccounttype(c.getDealeraccountdetails().getAccounttype());
		dealer.setAccountnumber(c.getDealeraccountdetails().getAccountnumber());
		cd.setDealeraccountdetails(dealer);
		
		//Setting Offer Letter
		emi.setEmiamountmonthly(c.getOfferletter().getEmidetails().getEmiamountmonthly());
		emi.setNextemiduedate(c.getOfferletter().getEmidetails().getNextemiduedate());
		emi.setPreviousemistatus(c.getOfferletter().getEmidetails().getPreviousemistatus());
		offerLetter.setEmidetails(emi);
		offerLetter.setLoanno(c.getOfferletter().getLoanno());
		offerLetter.setLoanamount(c.getOfferletter().getLoanamount());
		offerLetter.setRateofinterest(c.getOfferletter().getRateofinterest());
		offerLetter.setTenure(c.getOfferletter().getTenure());
		offerLetter.setTotalamounttobepaid(c.getOfferletter().getTotalamounttobepaid());
		offerLetter.setProcessingfees(c.getOfferletter().getProcessingfees());
		offerLetter.setTotalinterest(c.getOfferletter().getTotalinterest());
		offerLetter.setSanctiondate(c.getOfferletter().getSanctiondate());
		offerLetter.setRemark(c.getOfferletter().getRemark());
		offerLetter.setStatus(c.getOfferletter().getStatus());
		
		cd.setOfferletter(offerLetter);
		
		//Setting Saction letter
		sacLetter.setLoancaseno(c.getSanctionletter().getLoancaseno());
		cd.setSanctionletter(sacLetter);
		
		//Setting ledger Letter
		
		led.setAmountpaidtilldate(c.getLedger().getAmountpaidtilldate());
		led.setCurrentmonthemistatus(c.getLedger().getCurrentmonthemistatus());
		led.setDefaultercount(c.getLedger().getDefaultercount());
		led.setLedgercreateddate(c.getLedger().getLedgercreateddate());
		led.setLoanenddate(c.getLedger().getLoanenddate());
		led.setLoanstatus(c.getLedger().getLoanstatus());
		led.setMonthlyemi(c.getLedger().getMonthlyemi());
		led.setNextemidateend(c.getLedger().getNextemidateend());
		led.setNextemidatestart(c.getLedger().getNextemidatestart());
		led.setPayableamountwithinterest(c.getLedger().getPayableamountwithinterest());
		led.setPreviousemitstatus(c.getLedger().getPreviousemitstatus());
		led.setRemainingamount(c.getLedger().getRemainingamount());
		led.setTenure(c.getLedger().getTenure());
		led.setTotalloanamount(c.getLedger().getTotalloanamount());
		
		cd.setLedger(led);
		
		
		//Setting Loan Disbursment
		lDisburs.setAccountnumber(c.getLoandisbursment().getAccountnumber());
		lDisburs.setAccounttype(c.getLoandisbursment().getAccounttype());
		lDisburs.setAgreementdate(c.getLoandisbursment().getAgreementdate());
		lDisburs.setAmountpaiddate(c.getLoandisbursment().getAmountpaiddate());
		lDisburs.setAmountpaytype(c.getLoandisbursment().getAmountpaytype());
		lDisburs.setBankname(c.getLoandisbursment().getBankname());
		lDisburs.setIfsccode(c.getLoandisbursment().getIfsccode());
		lDisburs.setLoancaseno(c.getLoandisbursment().getLoancaseno());
		lDisburs.setPaymentstatus(null);
		lDisburs.setTotalamount(c.getLoandisbursment().getTotalamount());
		lDisburs.setTransferamount(c.getLoandisbursment().getTransferamount());
		
		cd.setLoandisbursment(lDisburs);
		
		this.cRS.postCust(cd);
		
		
		return new ResponseEntity<CustomerDetails>(cd,HttpStatus.CREATED);
	}
//Rajat
	@GetMapping("/getAllDoc")
	public List<CustomerDetails> getAllCustomerDetails() {
		
		
		return cRS.getAllApplicantDoc();
	}
	
	@GetMapping("/getSingleDoc/{id}")
	public CustomerDetails getSingleApplicantDoc(@PathVariable("id") Integer id) {
	
		CustomerDetails a=cRS.getSingleAppDoc(id);	
		return a;
}
	@GetMapping("/addCount/{custId}/{count}")
	public ResponseEntity<CustomerDetails> addDefaultCounte(@PathVariable("custId") Integer custId,@PathVariable("count") Integer count) {
		CustomerDetails cd = this.cRS.getSingleAppDoc(custId);
		
		cd.getLedger().setDefaultercount(count);
		System.out.println("------------------CustID-------------------Count------------------------");
		this.cRS.postCust(cd);
		
		return new ResponseEntity<CustomerDetails>(HttpStatus.CREATED);
		}

	
}

