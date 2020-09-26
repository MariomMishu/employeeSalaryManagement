package com.spring5.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_basic_salary")
public class BasicSalary implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "basic_salary", unique = true, nullable = false)
	private double basicSalary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public BasicSalary(long id, double basicSalary) {
		super();
		this.id = id;
		this.basicSalary = basicSalary;
	}

	public BasicSalary() {
		super();
	}

	@Override
	public String toString() {
		return "BasicSalary [id=" + id + ", basicSalary=" + basicSalary + "]";
	}
	
}
