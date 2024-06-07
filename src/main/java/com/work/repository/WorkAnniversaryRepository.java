
package com.work.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.model.WorkAnniversaryModel;

public interface WorkAnniversaryRepository extends JpaRepository<WorkAnniversaryModel,Integer> {
	Optional<WorkAnniversaryModel>findByimgName(String imgName);
	Optional<WorkAnniversaryModel>findByEmpId(Long empId);
	
}
