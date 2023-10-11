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
public class Enquirydetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	private String firstName;
	private String middleName;
	private String lastName;
	private String city;
	private String state;
	private String district;
	private Integer pincode;
    private String dob;
    private String email;
    private Double mobileNumber ;
    private String pancardNumber ;
    private String userName ;
    private String  passWord;

}
