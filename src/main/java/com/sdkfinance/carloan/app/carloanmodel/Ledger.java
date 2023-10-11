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
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ledgerid;
	private String ledgercreateddate;
	private Double totalloanamount;
	private Double payableamountwithinterest;
	private Integer tenure;
	private Double monthlyemi;
	private Double amountpaidtilldate;
	private Double remainingamount;
	private String nextemidatestart;
	private String nextemidateend;
	private Integer defaultercount;
	private String previousemitstatus;
	private String currentmonthemistatus;
	private String loanenddate;
	private String loanstatus;


}
