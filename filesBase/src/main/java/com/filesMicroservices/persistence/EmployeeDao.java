package com.filesMicroservices.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{

	static final String findEmployeeByCode = "SELECT e FROM Employee e WHERE e.code = :code";

	/**
	 * Find employee using their code as a reference
	 * @param code
	 * @return
	 */
	@Query(findEmployeeByCode)
    List<Employee> findEmployeeByCode(@Param("code") final String code);
}
