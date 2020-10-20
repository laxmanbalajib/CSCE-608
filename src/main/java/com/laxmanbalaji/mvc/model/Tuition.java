package com.laxmanbalaji.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TuitionFee")
public class Tuition {

	@Id
	@Column(name = "studentId")
	private int studentId;

	private int tuition;
	private int paid;
	
	@Override
	public String toString() {
		return "Tuition [studentId=" + studentId + ", tuition=" + tuition + ", paid=" + paid + "]";
	}

	/*
	@OneToOne
	@JoinColumn(name = "studentId")
	@MapsId
	private Student student; */

	
	
	

}
