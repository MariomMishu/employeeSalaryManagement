package com.spring5.practice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring5.practice.config.HibernateConfig;
import com.spring5.practice.model.Account;
import com.spring5.practice.model.BasicSalary;
import com.spring5.practice.model.Employee;


@Service
public class BasicSalaryService  extends HibernateConfig<BasicSalary> {
//	private final HibernateConfig hibernateConfig;

	//private static List<Grade> grades = new ArrayList<Grade>();

	
	
	  @Transactional 
	  public void add(BasicSalary bs) { 
		  delete(); 
		  this.save(bs);
	  }
	 
	public List<BasicSalary> getAll() {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<BasicSalary> cq = cb.createQuery(BasicSalary.class);
		cq.from(BasicSalary.class);
		return super.getListFromQuery(cq);
		}
	public void delete() {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaDelete<BasicSalary> cq = criteriaBuilder.createCriteriaDelete(BasicSalary.class);
		Root<BasicSalary> root = cq.from(BasicSalary.class);
		super.delete(cq);

	}
	
}
