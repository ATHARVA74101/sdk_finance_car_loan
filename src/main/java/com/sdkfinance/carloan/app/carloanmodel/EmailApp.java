package com.sdkfinance.carloan.app.carloanmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailApp 
{
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String textBody;
	

}
