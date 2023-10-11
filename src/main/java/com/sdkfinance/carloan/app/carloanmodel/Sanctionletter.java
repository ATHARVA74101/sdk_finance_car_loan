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
public class Sanctionletter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionid;
	private Integer loancaseno;

}
