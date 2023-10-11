package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Dealeraccountdetails {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer accountid;
	private String accounttype;
	private String accountholdername;
	private Double accountnumber;


}
