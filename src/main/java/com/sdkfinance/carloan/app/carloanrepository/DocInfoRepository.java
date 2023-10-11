package com.sdkfinance.carloan.app.carloanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sdkfinance.carloan.app.carloanmodel.DocInfo;
@Repository
public interface DocInfoRepository extends JpaRepository<DocInfo, Integer> {

	public DocInfo findByCustId(Integer id);
}
