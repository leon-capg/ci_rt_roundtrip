package com.capgemini.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.test.data.PersonBean;
import com.capgemini.test.data.PersonEntity;

public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	public EntityManagerFactory entityManagerFactory;

	public List<PersonBean> list() {
		List<PersonBean> beanList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tran = entityManager.getTransaction();
	    tran.begin();
		try {
			List<PersonEntity> entityList = entityManager.createQuery("from PersonEntity", PersonEntity.class).getResultList();
			beanList = new ArrayList<>();
			for(PersonEntity entity : entityList) {
				System.out.println(entity.getId() + " - " + entity.getLastName() + ", " + entity.getFirstName());
				beanList.add(DozerBeanMapperSingletonWrapper.getInstance().map(entity, PersonBean.class));
			}
			System.out.println("number of persons: " + entityList.size());
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		finally {			
			entityManager.close();
		}
		return beanList;
	}

	public PersonBean get(int id) {
		PersonBean bean = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tran = entityManager.getTransaction();
	    tran.begin();
		try {
			PersonEntity entity = entityManager.createQuery("from PersonEntity where id = :id", PersonEntity.class).setParameter("id", id).getSingleResult();
			bean = DozerBeanMapperSingletonWrapper.getInstance().map(entity, PersonBean.class);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		finally {			
			entityManager.close();
		}
		return bean;
	}

	public boolean add(PersonBean personBean) {
		boolean success = true;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tran = entityManager.getTransaction();
	    tran.begin();
		try {
			PersonEntity person = DozerBeanMapperSingletonWrapper.getInstance().map(personBean, PersonEntity.class);
			entityManager.persist(person);
			tran.commit();
			System.out.println("added new person ");
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			success = false;
		}
		finally {
			entityManager.close();
		}
		return success;
	}

	public boolean update(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		boolean success = true;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tran = entityManager.getTransaction();
	    tran.begin();
		try {
			entityManager.createQuery("delete from PersonEntity where id = :id").setParameter("id", id).executeUpdate();
			tran.commit();
			System.out.println("deleted person with id: "  + id);
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			success = false;
		}
		finally {
			entityManager.close();
		}
		return success;
	}

}
