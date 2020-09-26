package com.spring5.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring5.practice.config.HibernateConfig;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Account;
import com.spring5.practice.model.Employee;

@Service
public class EmployeeService extends HibernateConfig<Employee> {
	@Autowired
	BasicSalaryService basicSalaryService;
	public void add(Employee emp) {
		this.save(emp);
	}

	public void edit(Employee emp) {
		super.update(emp);
	}
	public Employee getById(long acId) {

		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.where(cb.equal(root.get("id"), acId));
		
		// perform query
		var ac_list = getListFromQuery(cq);

		return Optional.ofNullable(ac_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Thid Id"));
	}
	public void delete(long acId) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaDelete<Employee> cq = criteriaBuilder.createCriteriaDelete(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.where(criteriaBuilder.equal(root.get("id"), acId));
		super.delete(cq);

	}
	//private GradeService gradeService;

	/*
	 * public void add(Employee emp) { // // var grade =
	 * gradeService.getByCode(emp.getGrade().getGrade()); // emp.setGrade(grade);
	 * 
	 * var session = hibernateConfig.getSession(); var transaction =
	 * session.getTransaction(); if (!transaction.isActive()) { transaction =
	 * session.beginTransaction(); } try { session.save(emp); transaction.commit();
	 * } catch (HibernateException e) { if (transaction != null) {
	 * transaction.rollback(); } e.printStackTrace(); }
	 * 
	 * }
	 */
	
	public double basicSalary(Employee emp, Double salary) { 
		  
		 double house; double mc; double basic; double total=0.00;
		    if(emp.getGrade().equals("Six")) {
				  basic= salary;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }else if(emp.getGrade().equals("Five")) {
				  basic= salary+5000.00;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }else if(emp.getGrade().equals("Four")) {
				  basic= salary+10000.00;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }else if(emp.getGrade().equals("Three")) {
				  basic= salary+15000.00;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }
			  else if(emp.getGrade().equals("Two")) {
				  basic= salary+20000.00;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }
			  else if(emp.getGrade().equals("One")) {
				  basic= salary+25000.00;
				  house= basic*20/100;
				  mc= basic*15/100;
				  total=basic+house+mc;
			  }
			  else {
				  total=0.00;
			  }
	  
		  //salary_list = basicSalaryService.getAll(); 
		  return total;
	  }
	 

	public List<Employee> getAll() {
		
		// **************************** HQL Start ******************************//
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		cq.from(Employee.class);
		var empList = super.getListFromQuery(cq);
		var basicList = basicSalaryService.getAll();
		System.out.println(basicList.size());
		if(basicList.size() >0) {
			Double basic = basicList.get(0).getBasicSalary();
			System.out.println(basic);
			for(var emp : empList) {
				if(basic>0.00) {
					emp.setSalary(basicSalary(emp, basic));	
				}else {
					basic=0.00;
					emp.setSalary(basicSalary(emp, basic));
				}
				
			}
		}
		/*
		 * else { for(var emp : empList) { emp.setSalary(basicSalary(emp, basic)); }
		 * emp.setSalary(0.00); }
		 */
		
		return empList;
		
		// **************************** HQL End ******************************//
		/*
		 * var session = hibernateConfig.getSession(); var transaction =
		 * session.getTransaction(); if (!transaction.isActive()) { transaction =
		 * session.beginTransaction(); }
		 * 
		 * // Start Criteria Query CriteriaBuilder cb = session.getCriteriaBuilder();
		 * CriteriaQuery<Employee> sc = cb.createQuery(Employee.class); Root<Employee>
		 * root = sc.from(Employee.class); sc.select(root); var query =
		 * session.getEntityManagerFactory().createEntityManager().createQuery(sc); //
		 * end Criteria Query
		 * 
		 * var employee_list = query.getResultList(); return employee_list;
		 */
	}

	/*public Employee getById(long empId) {

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> sc = cb.createQuery(Employee.class);
		Root<Employee> root = sc.from(Employee.class);
		sc.where(cb.equal(root.get("id"), empId));
		// sc.select(root);
		var query = session.getEntityManagerFactory().createEntityManager().createQuery(sc);
		var emp_list = query.getResultList();

		return Optional.ofNullable(emp_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Thid Id"));
	}

	public void edit(Employee emp) {
		//var grade = gradeService.getByCode(emp.getGrade().getGrade());
		//emp.setGrade(grade);

		var session = hibernateConfig.getSession();
		var transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		try {
			session.update(emp);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void delete(long empId) {
		var session = hibernateConfig.getSession();
		var transection = session.beginTransaction();
		if (!transection.isActive()) {
			transection = session.beginTransaction();
		}
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaDelete<Employee> sc = criteriaBuilder.createCriteriaDelete(Employee.class);
		Root<Employee> root = sc.from(Employee.class);
		sc.where(criteriaBuilder.equal(root.get("id"), empId));
		var query = session.createQuery(sc);
		try {
			query.executeUpdate();
		} catch (HibernateException e) {
			if (transection != null) {
				transection.rollback();
			}
			e.printStackTrace();
		}

	}*/

}
