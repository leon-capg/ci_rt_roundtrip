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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
