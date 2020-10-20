package com.laxmanbalaji.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laxmanbalaji.mvc.model.Earn;


@Repository
public interface EarnRepo extends CrudRepository<Earn, Integer>{

	@Query(value = "SELECT * FROM Earn", nativeQuery = true)
	List<Earn> getAllEarning();
	
	@Query(value = "SELECT * FROM Earn WHERE staffId = :staffId", nativeQuery = true)
	Earn getAllEarnByStaffId(int staffId);
	
	@Modifying
	@Query(value = "INSERT INTO Earn(staffId, salary) VALUES(:staffId, :salary)", nativeQuery = true)
	@Transactional
	void insertEarning(int staffId, int salary);
	
	@Modifying
	@Query(value = "UPDATE Earn SET salary = :salary WHERE staffId = :staffId", nativeQuery = true)
	@Transactional
	void updateEarning(int staffId, int salary);
}
