package com.jweekend.data.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dataobjects.Event;
import com.wideplay.warp.persist.Transactional;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class EventDaoJPAImp extends AbstractDaoJPAImpl<Event> implements EventDao {

	public EventDaoJPAImp() {
		super(Event.class);
	}

	@Transactional
	public List<Event> findAll() {
		TypedQuery<Event> query = em.get().createQuery("select e from Event e", Event.class);
		return query.getResultList();
	}

	@Transactional
	public int countAll() {
		TypedQuery<Long> query = em.get().createQuery("select count (e) from Event e", Long.class);
		return (query.getSingleResult()).intValue();
	}
}
