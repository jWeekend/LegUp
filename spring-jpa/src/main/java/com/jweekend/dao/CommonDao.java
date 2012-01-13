package com.jweekend.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.Dao;
import com.jweekend.entity.DomainObject;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
@Transactional
@Repository
public abstract class CommonDao<T extends DomainObject, K extends Serializable>  implements Dao<T, K> {

	private final Class<T> clazz;

	@PersistenceContext
    private EntityManager entityManager;
	
	public CommonDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jweekend.dao.interfaces.Dao#delete(com.jweekend.entity.DomainObject)
	 */
	public void delete(T o) {
		entityManager.remove(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#load(java.io.Serializable)
	 */
	public T load(K id) {
		return entityManager.find(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jweekend.dao.interfaces.Dao#save(com.jweekend.entity.DomainObject)
	 */
	public T save(T o) {
		return entityManager.merge(o);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
