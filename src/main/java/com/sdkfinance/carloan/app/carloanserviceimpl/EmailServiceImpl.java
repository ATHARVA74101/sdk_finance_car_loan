package com.sdkfinance.carloan.app.carloanserviceimpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sdkfinance.carloan.app.carloanmodel.EmailApp;
import com.sdkfinance.carloan.app.carloanserviceinterface.EmailServiceI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailServiceImpl implements EmailServiceI
{
	@Autowired
	JavaMailSender jms;

	@Override
	public void sendEmail(EmailApp e)
	{
		try {
			SimpleMailMessage smm =new SimpleMailMessage();
			
			smm.setFrom(e.getFromEmail());
			smm.setTo(e.getToEmail());
			smm.setSubject(e.getSubject());
			smm.setText(e.getTextBody());
		
			jms.send(smm);
			
		} 
		catch (Exception e2)
		{
			e2.printStackTrace();
			log.info("Service: Mail Not Sent");
		}
		log.info("Service: Mail Sent Success ");
	}

	@Override
	public void sendMailWithAttch(EmailApp e, MultipartFile f) {
		// TODO Auto-generated method stub
		
		MimeMessage mm = jms.createMimeMessage();
		
		try {
				MimeMessageHelper mmh = new MimeMessageHelper(mm,true);
				mmh.setFrom(e.getFromEmail());
				mmh.setTo(e.getToEmail());
				mmh.setSubject(e.getSubject());
				mmh.setText(e.getTextBody());
				
				mmh.addAttachment(f.getOriginalFilename(), f);
				jms.send(mm);
		} 
		catch (Exception e2) 
		{
			e2.getStackTrace();
			log.info("Service: Mail Not Send");
		}
	}
}
