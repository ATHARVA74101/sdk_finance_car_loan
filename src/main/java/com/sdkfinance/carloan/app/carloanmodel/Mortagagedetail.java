package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Mortagagedetail {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer mortgageid;
	private Double mortgagepropertyvalue;
	@Lob
	private byte[] mortgagepropertyproof;
	private String mortgagepropertytype;
	private Double mortgageloanonproperty;

}
