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
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer customerid;
	  private String customerfirstname;
	  private String customermiddlename ;
	  private String customerlastname;
	  private String customerdob;
	  private String customergender;
	  private String customeremail;
	  private Double customermobilenumber;
	  private Double customeradditionalmobilenumber;
	  private Double customeramountpaidforcar;
	  private Double customertotalloanrequired;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Occupation Occupation;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Documents Documents;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Currentaddress Currentaddress;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Permentaddress Permentaddress;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Mortagagedetail Mortagagedetail;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Previousloan Previousloan;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Dealeraccountdetails Dealeraccountdetails;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Guarantordetail Guarantordetail;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Cibil Cibil;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Offerletter Offerletter;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Sanctionletter Sanctionletter;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Ledger Ledger;
	  @OneToOne(cascade = CascadeType.ALL)
	  private Loandisbursment Loandisbursment;

}
