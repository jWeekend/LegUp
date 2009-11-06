package com.jweekend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.EventDao;
import com.jweekend.entity.Event;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
@Transactional
public class JpaEventDAO extends CommonDao<Event> implements EventDao {

	/**
	 * @param clazz
	 */
	public JpaEventDAO() {
		super(Event.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#countAll()
	 */
	public int countAll() {
		return ((Long) getJpaTemplate().execute(new JpaCallback() {

			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query query = em.createQuery("select count(e) from Event e");
				return query.getSingleResult();
			}
		})).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Event> findAll() {
		return getJpaTemplate().find("select e from Event e");
	}

}
