package com.jweekend.data.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dataobjects.Event;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
public class EventDaoJPAImp extends AbstractDaoJPAImpl<Event> implements EventDao {

	public EventDaoJPAImp() {
		super(Event.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Event> findAll() {
		return getJpaTemplate().execute(new JpaCallback<List<Event>>() {
			public List<Event> doInJpa(EntityManager em) throws PersistenceException {
				Query query = em.createQuery("select e from Event e");
				return query.getResultList();
			}
		});
	}

	@Transactional
	public int countAll() {
		return getJpaTemplate().execute(new JpaCallback<Integer>() {
			
			public Integer doInJpa(EntityManager em) throws PersistenceException {
				Query query = em.createQuery("select count (e) from Event e");
				return ((Long) query.getSingleResult()).intValue();
			}
		});
		
	}
}
