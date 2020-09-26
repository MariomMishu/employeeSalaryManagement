package com.spring5.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account")
public class Account implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "ac_name")
	private String acName;
	@Column(name = "ac_number")
	private String acNumber;
	@Column(name = "ac_type")
	private String acType;
	@Column(name = "balance")
	private double balance;
	@Column(name = "bank")
	private String bank;
	@Column(name = "branch")
	private String branch;
	
	public Account() {
		super();
	}

	public Account(long id, String acName, String acNumber, String acType, double balance, String bank, String branch) {
		super();
		this.id = id;
		this.acName = acName;
		this.acNumber = acNumber;
		this.acType = acType;
		this.balance = balance;
		this.bank = bank;
		this.branch = branch;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", acName=" + acName + ", acNumber=" + acNumber + ", acType=" + acType
				+ ", balance=" + balance + ", bank=" + bank + ", branch=" + branch + "]";
	}
	
	
	
}
