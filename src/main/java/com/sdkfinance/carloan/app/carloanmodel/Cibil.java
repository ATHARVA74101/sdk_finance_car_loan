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
public class Cibil 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer	cibilid;
		private String pannumber;
		private Integer	cibilscore;
		private String cibilscoredatetime;
		private String status;
		private String remark;

}
