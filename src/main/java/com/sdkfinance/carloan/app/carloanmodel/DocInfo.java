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
public class DocInfo {

	@Id
	private Integer custId;
	private Integer status;
	private String firstName ;
    private String middleName;
    private String lastName;
}
