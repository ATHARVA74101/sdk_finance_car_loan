package com.sdkfinance.carloan.app.carloancontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdkfinance.carloan.app.carloanmodel.CustomerDetails;
import com.sdkfinance.carloan.app.carloanmodel.EmailApp;
import com.sdkfinance.carloan.app.carloanrepository.CustomerRegistrationRepository;
import com.sdkfinance.carloan.app.carloanserviceinterface.EmailServiceI;

import lombok.CustomLog;


@CrossOrigin("*")
@RestController
@RequestMapping("/email")
public class EmailController 
{
	@Autowired
	private EmailServiceI es;
	
	@Autowired
	private CustomerRegistrationRepository crr;
	
	@Value("$(spring.mail.username)") String fromEmail;

//	@PostMapping("/sendEmail")
	@RequestMapping(value="/sendEmail", method=RequestMethod.POST)
	public String sendEmail(@RequestBody EmailApp e)
	{
		System.out.println("Controller");
		e.setFromEmail(fromEmail);
		
		try 
		{
			es.sendEmail(e);
			
		} catch (Exception e2) 
		{
			e2.printStackTrace();
			return "Sent mail Fail";
		}
		
		return "Email Send Successfully!";
	}
	
	@PostMapping(value = "/sendAttachEmail", consumes = MediaType.ALL_VALUE)
	public String sendMailAttacment(@RequestPart(required=true,value="Attachment")MultipartFile f, @RequestPart("email") String email) throws IOException
	{
		
		try {
				EmailApp e = new EmailApp();
				e.setFromEmail(fromEmail);
				
				ObjectMapper o =new ObjectMapper();
				
				EmailApp e1= o.readValue(email, EmailApp.class);
				e.setToEmail(e1.getToEmail());
				e.setSubject(e1.getSubject());
				e.setTextBody(e1.getTextBody());
				
				es.sendMailWithAttch(e,f);
			} 
		catch (Exception e) 
		{
		  e.printStackTrace();
		  return "Email Sent Fail";
		}
		return "Email Sent Success";
	}
	//"email/setemailstatus/"
	
	@GetMapping("/setemailstatus/{id}")
	public String emailStatus(@PathVariable("id") Integer id)
	{
		CustomerDetails abc = this.crr.findByCustomerid(id);
		System.out.println("in Email Remark");
//		abc.getOfferletter().setProcessingfees(2566.6);
		abc.getOfferletter().setRemark("1");
		this.crr.save(abc);
		return "CM Updated";
	}
	
	@GetMapping("/setsactionstatus/{id}")
	public String setsactionstatus(@PathVariable("id") Integer id)
	{
		CustomerDetails abc = this.crr.findByCustomerid(id);
//		System.out.println("in Email Remark");
//		abc.getOfferletter().setProcessingfees(2566.6);
		abc.getSanctionletter().setLoancaseno(1);
		this.crr.save(abc);
		return "CM Updated";
	}
}
