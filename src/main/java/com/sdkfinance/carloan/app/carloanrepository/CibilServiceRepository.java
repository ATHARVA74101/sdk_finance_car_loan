package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdkfinance.carloan.app.carloanmodel.CibilStatus;

@Repository
public interface CibilServiceRepository extends JpaRepository<CibilStatus, Integer> {

	public CibilStatus findByEid(Integer eid);
}
