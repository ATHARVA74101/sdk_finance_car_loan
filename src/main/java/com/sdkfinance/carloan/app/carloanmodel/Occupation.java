package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Occupation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer occupationid;
	private String occupationtype;
	private Double salary;
	private Integer remainingWorkingPeriod;
	private String designation;
	@Lob
	private byte[]  salrySlip;


}
