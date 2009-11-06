package com.jweekend.wicket;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.jweekend.HomePage;
import com.jweekend.WicketApplication;
import com.jweekend.config.modules.MockDAOModule;
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
		tester = new WicketTester(new WicketApplication(){
			/* (non-Javadoc)
			 * @see com.jweekend.WicketApplication#getGuiceInjector()
			 */
			@Override
			protected GuiceComponentInjector getGuiceInjector() {
				return  new GuiceComponentInjector(this, Guice.createInjector(new MockDAOModule()));
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
