package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Loandisbursment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loandisid;
	private Integer loancaseno;
	private String agreementdate;
	private String amountpaytype;
	private Double totalamount;
	private String bankname;
	private Double accountnumber;
	private String ifsccode;
	private String accounttype;
	private Double transferamount;
	private String paymentstatus;
	private String amountpaiddate;

}
