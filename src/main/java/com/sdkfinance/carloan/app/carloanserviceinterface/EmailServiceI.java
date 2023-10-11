package com.sdkfinance.carloan.app.carloanserviceinterface;

import org.springframework.web.multipart.MultipartFile;

import com.sdkfinance.carloan.app.carloanmodel.EmailApp;



public interface EmailServiceI {

	void sendEmail(EmailApp e);

	void sendMailWithAttch(EmailApp e, MultipartFile f);

}
