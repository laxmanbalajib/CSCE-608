package com.laxmanbalaji.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Staff")
public class Staff {

	@Id
	private int id;

	private String name;
	private String gender;

	/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "Teach", joinColumns = {
			@JoinColumn(name = "staffId", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", nullable = false, updatable = false) })
	private Set<Course> courses = new HashSet<>(); // use this name in mapping


	@ManyToOne(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    private Earn earning;
	
	public Earn getEarning() {
		return earning;
	}
	*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Staff() {
	}

	public Staff(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}




}
