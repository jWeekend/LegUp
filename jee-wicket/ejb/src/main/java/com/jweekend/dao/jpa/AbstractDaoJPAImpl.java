package com.jweekend.dao.jpa;

import java.io.Serializable;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jweekend.dataobjects.DomainObject;
import com.jweekend.local.Dao;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 */
@TransactionAttribute
public abstract class AbstractDaoJPAImpl<T extends DomainObject> implements Dao<T> {

	private Class<T> domainClass;

	@PersistenceContext(unitName = "myFirstJpaUnit")
	protected EntityManager em;

	public AbstractDaoJPAImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	public void delete(T object) {
		if (!em.contains(object)) {
			object = em.merge(object);
		}
		em.remove(object);
	}

	public T load(Serializable id) {
		return em.find(domainClass, id);
	}

	public T save(T object) {
		return em.merge(object);
	}

}
