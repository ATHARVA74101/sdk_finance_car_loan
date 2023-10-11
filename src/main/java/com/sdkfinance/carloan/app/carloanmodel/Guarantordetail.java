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
public class Guarantordetail {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer gid;
	private String guarantorname;
	private String relationwithclient;
	private String profession;
	private Double mobileno;
	private String address;
	private Integer pincode;
	private String city;
	private String district;
	private String state;
	private String country;
	private Double aadharno;
	private String panno;

}
