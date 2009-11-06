package com.jweekend.run;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jweekend.dao.interfaces.EventDao;
import com.jweekend.entity.Event;
import com.jweekend.entity.Location;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EventDao eventDao = (EventDao) ctx.getBean("eventDao");

		Location location = new Location();
		location.setAddress("1 high street");
		location.setName("location");

		Event event = new Event();
		event.setName("event name");
		event.setDescription("description");
		event.setLocation(location);
		event.setDate(new Timestamp(System.currentTimeMillis()));

		event = eventDao.save(event);

		System.out.println(event);
	}

}
