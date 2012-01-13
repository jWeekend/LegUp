package com.jweekend.data.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dataobjects.Event;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
@Repository
public class EventDaoJPAImp extends AbstractDaoJPAImpl<Event, Long> implements EventDao {

	public EventDaoJPAImp() {
		super(Event.class);
	}

	@Transactional
	public List<Event> findAll() {
		TypedQuery<Event> query = getEntityManager().createQuery("select e from Event e", Event.class);
		return query.getResultList();
	}

	@Transactional
	public int countAll() {		
		TypedQuery<Long> query = getEntityManager().createQuery("select count (e) from Event e", Long.class);
		return (query.getSingleResult()).intValue();

	}
}
