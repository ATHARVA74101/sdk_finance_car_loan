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
public class Documents {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer documentID;
	private String qualification;
	@Lob
	private byte[] addharcard;
	
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] lastthreeyearITR;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] bankcheque;
	
	

}
