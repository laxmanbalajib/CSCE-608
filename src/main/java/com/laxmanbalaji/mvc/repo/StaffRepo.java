package com.laxmanbalaji.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laxmanbalaji.mvc.model.Staff;

public interface StaffRepo extends CrudRepository<Staff, Integer> {

	@Query(value = "SELECT * FROM Staff", nativeQuery = true)
	List<Staff> getAllStaff();

	@Query(value = "SELECT * FROM Staff WHERE id = :staffId", nativeQuery = true)
	Staff getStaffById(int staffId);

	@Query(value = "SELECT * FROM Staff,Earn WHERE Earn.salary >= :salaryStart AND Earn.salary <= :salaryEnd  AND Earn.staffId = Staff.id", nativeQuery = true)
	List<Staff> getStaffBySalary(int salaryStart, int salaryEnd);

	@Modifying
	@Query(value = "INSERT INTO Staff(id, name, gender) VALUES(:staffId, :staffName, :gender)", nativeQuery = true)
	@Transactional
	void insertStaff(int staffId, String staffName, String gender);
}
