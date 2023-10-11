package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Offerletter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currentloanid;
	private Integer loanno;
	@OneToOne(cascade = CascadeType.ALL)
	private Emidetail emidetails;
	private Double loanamount;
	private Double rateofinterest;
	private Integer tenure;
	private Double totalamounttobepaid;
	private Double processingfees;
	private Double totalinterest;
	private String  sanctiondate;
	private String remark;
	private String status;


}
