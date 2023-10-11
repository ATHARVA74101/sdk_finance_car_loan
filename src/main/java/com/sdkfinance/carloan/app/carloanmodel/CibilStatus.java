package com.sdkfinance.carloan.app.carloanmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CibilStatus {
	@Id
	private Integer eid;
	private Integer status;
	private Integer cibilscore;
}
