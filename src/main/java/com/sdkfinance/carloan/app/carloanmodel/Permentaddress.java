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
public class Permentaddress {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer permentaddressid;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Integer pincode;
	private Integer housenumber;
	private String streetname;

}
