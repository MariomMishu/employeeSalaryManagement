package com.spring5.practice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import com.spring5.practice.config.HibernateConfig;
import com.spring5.practice.exceptions.ResourceNotFoundException;
import com.spring5.practice.model.Account;

@Service
public class AccountService extends HibernateConfig<Account>{
	
	public void add(Account ac) {
		this.save(ac);
	}

	public List<Account> getAll() {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		cq.from(Account.class);
		return super.getListFromQuery(cq);
	}

	public Account getById(long acId) {

		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		Root<Account> root = cq.from(Account.class);
		cq.where(cb.equal(root.get("id"), acId));
		
		// perform query
		var ac_list = getListFromQuery(cq);

		return Optional.ofNullable(ac_list.get(0))
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found With Thid Id"));
	}

	public void edit(Account ac) {
		super.update(ac);
	}

	public void delete(long acId) {
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaDelete<Account> cq = criteriaBuilder.createCriteriaDelete(Account.class);
		Root<Account> root = cq.from(Account.class);
		cq.where(criteriaBuilder.equal(root.get("id"), acId));
		super.delete(cq);

	}

}
