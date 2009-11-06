package com.jweekend.data.dao.hibernate;

import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dataobjects.Event;
/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class EventDaoHibernateImp extends AbstractDaoHibernateImpl<Event> implements EventDao {

	public EventDaoHibernateImp()
	{
		super(Event.class);
	}
}
