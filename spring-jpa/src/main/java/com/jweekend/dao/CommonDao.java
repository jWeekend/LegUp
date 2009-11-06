package com.jweekend.dao;

import java.io.Serializable;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.Dao;
import com.jweekend.entity.DomainObject;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
@Transactional
public abstract class CommonDao<T extends DomainObject> extends JpaDaoSupport implements Dao<T> {

	private final Class<T> clazz;

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
		getJpaTemplate().remove(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#load(java.io.Serializable)
	 */
	public T load(Serializable id) {
		return getJpaTemplate().find(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jweekend.dao.interfaces.Dao#save(com.jweekend.entity.DomainObject)
	 */
	public T save(T o) {
		return getJpaTemplate().merge(o);
	}

}
