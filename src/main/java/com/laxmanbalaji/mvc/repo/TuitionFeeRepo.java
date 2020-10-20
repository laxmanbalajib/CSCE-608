package com.laxmanbalaji.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.laxmanbalaji.mvc.model.Tuition;



public interface TuitionFeeRepo extends CrudRepository<Tuition, Integer>{

}
