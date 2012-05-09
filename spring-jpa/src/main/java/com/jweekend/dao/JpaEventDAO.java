package com.jweekend.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.EventDao;
import com.jweekend.entity.Event;

/**
 * 
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * @author Erensto Reinaldo 
 *
 */
@Transactional
public class JpaEventDAO extends CommonDao<Event, Long> implements EventDao {

	public JpaEventDAO() {
		super(Event.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.jweekend.dao.interfaces.Dao#countAll()
	 */
	public int countAll() {		
		TypedQuery<Long> query = getEntityManager().createQuery("select count(e) from Event e", Long.class);
		return query.getSingleResult().intValue();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.jweekend.dao.interfaces.Dao#findAll()
	 */
	public List<Event> findAll() {
		TypedQuery<Event> query = getEntityManager().createQuery("select e from Event e", Event.class);
		return query.getResultList();
	}

}
