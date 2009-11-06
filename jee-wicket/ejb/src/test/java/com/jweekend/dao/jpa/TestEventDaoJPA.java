package com.jweekend.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jweekend.dataobjects.Event;
import com.jweekend.local.EventDao;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 */
public class TestEventDaoJPA {

	protected static EventDao eventDao;

	protected static Event event;

	@BeforeClass
	public static void startTransaction() {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		p.put("movieDatabase", "new://Resource?type=DataSource");
		p.put("movieDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("movieDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");

		p.put("openejb.jndiname.format ", " {ejbName}");
		p.put("openejb.descriptors.output ", " true");
		p.put("openejb.validation.output.level ", " verbose");

		InitialContext context = null;
		try {
			context = new InitialContext(p);
		}
		catch (NamingException e) {
			e.printStackTrace();
		}

		try {
			eventDao = (EventDao) context.lookup("EventDaoJPAImpLocal");
		}
		catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Before
	public void addEvent() {
		event = new Event();
		event.setLocation("new Location");
		event.setTitle("new Title");
		event = eventDao.save(event);
	}

	@After
	public void deleteEvent() {
		eventDao.delete(event);
	}

	/**
	 * Test method for {@link com.jweekend.data.dao.jpa.EventDaoJPAImp#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Event> events = new ArrayList<Event>();
		events.add(event);
		Assert.assertEquals(events, eventDao.findAll());
	}

	/**
	 * Test method for {@link com.jweekend.data.dao.jpa.EventDaoJPAImp#countAll()}.
	 */
	@Test
	public void testCountAll() {
		Assert.assertEquals(1, eventDao.countAll());
	}

	/**
	 * Test method for {@link com.jweekend.data.dao.jpa.AbstractDaoJPAImpl#delete(com.jweekend.data.dataobjects.DomainObject)}.
	 */
	@Test
	public void testDelete() {
		eventDao.delete(event);
		Assert.assertEquals(0, eventDao.countAll());

		// add it back
		event = eventDao.save(event);
	}

	/**
	 * Test method for {@link com.jweekend.data.dao.jpa.AbstractDaoJPAImpl#load(java.io.Serializable)}.
	 */
	@Test
	public void testLoad() {
		Event event2 = eventDao.load(event.getId());
		Assert.assertEquals(event, event2);
	}

	/**
	 * Test method for {@link com.jweekend.data.dao.jpa.AbstractDaoJPAImpl#save(com.jweekend.data.dataobjects.DomainObject)}.
	 */
	@Test
	public void testSave() {
	// if we have got this far then save works
	}

}
