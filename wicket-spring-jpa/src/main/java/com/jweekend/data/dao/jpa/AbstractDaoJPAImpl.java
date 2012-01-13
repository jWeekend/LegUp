package com.jweekend.data.dao.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.data.dao.interfaces.Dao;
import com.jweekend.data.dataobjects.DomainObject;
/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
@Repository
public abstract class AbstractDaoJPAImpl<T extends DomainObject, K extends Serializable> implements Dao<T, K> {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private Class<T> domainClass;
	

	public AbstractDaoJPAImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}
	
	@Transactional
	public void delete(T object)
	{ 
		entityManager.remove(object);
	}
	
	@Transactional
	public T load(K id)
	{
		return entityManager.find(domainClass, id);
	}
	
	@Transactional
	public T save(T object)
	{
		return entityManager.merge(object);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}

