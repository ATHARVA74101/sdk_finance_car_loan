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
public class Previousbankloandetails {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer branchid;
	private String branchname;
	private Integer branchcode;
	private String branchtype;
	private String ifsccode;
	private String micrcode;
	private Double conatctnumber;
	private String bankaddress;
	private String email;

}
