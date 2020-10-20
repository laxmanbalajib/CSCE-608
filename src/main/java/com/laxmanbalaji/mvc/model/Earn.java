package com.laxmanbalaji.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Earn")
public class Earn {

	@Id
	@Column(name="staffId")
	private int staffId;

	private int salary;

	@Override
	public String toString() {
		return "Earn [staffId=" + staffId + ", salary=" + salary + "]";
	}

	/*
    @OneToOne
    @JoinColumn(name = "staffId")
    @MapsId
    private Staff staff; */

	
    
    
}

