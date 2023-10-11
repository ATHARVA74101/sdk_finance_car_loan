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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Previousloan {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer previousLoanid;
	private Double previousLoanamount;
	private Integer previousloantenure;
	private Double previousloanpaidamount;
	private Double previousloanremainingamount;
	@OneToOne(cascade = CascadeType.ALL)
	private Previousbankloandetails Previousbankloandetails ;
	private String previousloanstatus;
}
