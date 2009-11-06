package com.jweekend.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.Query;

import com.jweekend.dataobjects.Event;
import com.jweekend.local.EventDao;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 */
@Stateless
// (mappedName = "ejb/EventDao")
@TransactionAttribute
public class EventDaoJPAImp extends AbstractDaoJPAImpl<Event> implements EventDao {

	public EventDaoJPAImp() {
		super(Event.class);
	}

	@SuppressWarnings("unchecked")
	public List<Event> findAll() {
		Query query = em.createQuery("select e from Event e");
		return query.getResultList();
	}

	public int countAll() {
		Query query = em.createQuery("select count (e) from Event e");
		return ((Long) query.getSingleResult()).intValue();
	}

}
