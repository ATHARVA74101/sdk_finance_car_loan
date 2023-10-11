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
public class Emidetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emiid;
	private Double emiamountmonthly;
	private String nextemiduedate;
	private String previousemistatus;

}
