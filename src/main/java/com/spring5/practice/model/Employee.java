package com.spring5.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "grade")
	private String grade;
	@Column(name = "rank")
	private String rank;
	@Column(name = "address")
	private String address;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "account")
	private String account;
	
	@Transient
	private Double salary;
	
	
	public Employee() {
		super();
	}
	
	public Employee(long id, String name, String grade, String rank, String address, String mobile, String account) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.rank = rank;
		this.address = address;
		this.mobile = mobile;
		this.account = account;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
}
