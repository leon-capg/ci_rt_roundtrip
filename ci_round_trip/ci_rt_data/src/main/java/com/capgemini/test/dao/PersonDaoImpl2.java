package com.capgemini.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.test.data.PersonBean;
import com.capgemini.test.data.PersonEntity;


public class PersonDaoImpl2 implements PersonDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<PersonBean> list() {
		List<PersonEntity> entityList = entityManager.createQuery("from PersonEntity", PersonEntity.class)
				.getResultList();
		List<PersonBean> beanList = new ArrayList<>();
		for (PersonEntity entity : entityList) {
			System.out.println(entity.getId() + " - " + entity.getLastName() + ", " + entity.getFirstName());
			beanList.add(DozerBeanMapperSingletonWrapper.getInstance().map(entity, PersonBean.class));
		}
		return beanList;
	}

	@Override
	public PersonBean get(int id) {
		PersonEntity entity = entityManager.createQuery("from PersonEntity where id = :id", PersonEntity.class)
				.setParameter("id", id).getSingleResult();
		if (entity != null) {
			return DozerBeanMapperSingletonWrapper.getInstance().map(entity, PersonBean.class);
		}
		return null;
	}

	@Override
	public boolean add(PersonBean person) {
		try {
			PersonEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(person, PersonEntity.class);
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(PersonBean person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			entityManager.createQuery("delete from PersonEntity where id = :id").setParameter("id", id).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
