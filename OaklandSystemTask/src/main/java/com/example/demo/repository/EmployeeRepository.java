package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	
	 Optional<EmployeeEntity> findByLoginId(String loginId);
	 
	   List<EmployeeEntity> findByIdNot(Long Id);
}
