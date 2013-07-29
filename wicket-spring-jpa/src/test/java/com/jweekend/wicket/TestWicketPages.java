package com.jweekend.wicket;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.jweekend.HomePage;
import com.jweekend.WicketApplication;
import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.pages.EventPage;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class TestWicketPages {
	
	protected WicketTester tester;
	
	@Before
	public void setup()
	{
		final ApplicationContextMock acm = new ApplicationContextMock();
		
		EventDao eventDao = Mockito.mock(EventDao.class);
		
		acm.putBean("eventDao", eventDao);
		
		tester = new WicketTester(new WicketApplication(){
			@Override
			protected SpringComponentInjector getSpringInjector() {
				return  new SpringComponentInjector(this, acm, true);
			}
		});
	}
	
	@Test
	public void testStartPage()
	{
		tester.startPage(HomePage.class);
	}
	
	@Test
	public void testEventPage()
	{
		tester.startPage(EventPage.class);
	}

}
