package com.spring5.practice.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import com.spring5.practice.model.Account;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Properties;

public class HibernateConfig <T>{
	
    private SessionFactory sessionFactory = null;

    private Session session;
    
    

//    public HibernateConfig(T obj) {
//		super();
//		this.obj = obj;
//	}

	private Session getSession() {
        this.session = createAndGetLocalSessionFactoryBean().getCurrentSession();
        return session != null
                ? this.session
                : createAndGetLocalSessionFactoryBean().openSession();
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        Session session = getSession();
        var tx = session.getTransaction();
        if(!tx.isActive()) {
        	tx = session.beginTransaction();
        }
        return session.getCriteriaBuilder();
    }

    protected EntityManager entityManager() {
        return createAndGetLocalSessionFactoryBean().createEntityManager();
    }

    private SessionFactory createAndGetLocalSessionFactoryBean() {
        if (this.sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = getBuiltProperties("hibernate.properties");

                configuration.setProperties(settings);
                configuration.addPackage("com.spring5.practice.model");
                for (Class<?> clazz : (new Reflections("com.spring5.practice.model")).getTypesAnnotatedWith(Entity.class)) {
                    if (!Modifier.isAbstract(clazz.getModifiers())) {
                        configuration.addAnnotatedClass(clazz);
                    }
                }
                StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(settings);
                sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private Properties getBuiltProperties(String propertyFileName) {
        Properties properties = new Properties();
        InputStream input = HibernateConfig.class
                .getClassLoader().getResourceAsStream(propertyFileName);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    protected void save(T obj) {
    	var session = this.getSession();
    	var transaction = session.getTransaction();
    	if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		session.save(obj);
		transaction.commit();
		session.close();
    }
    
    protected List<T> getListFromQuery (CriteriaQuery<T> cq) {
    	session = this.getSession();
    	var query = this.getSession().getEntityManagerFactory().createEntityManager().createQuery(cq);
    	List<T> list = query.getResultList();
    	session.close();
    	return list;
    }
    
    protected void update(T obj) {
    	var session = this.getSession();
    	var transaction = session.getTransaction();
    	if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
		session.update(obj);
		transaction.commit();
		session.close();
    }
    
    protected void delete(CriteriaDelete<T> cq) {
    	var session = getSession();
    	var transaction = session.getTransaction();
    	if (!transaction.isActive()) {
			transaction = session.beginTransaction();
		}
    	var query = session.createQuery(cq);
    	try {
			query.executeUpdate();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

    }
    
}
