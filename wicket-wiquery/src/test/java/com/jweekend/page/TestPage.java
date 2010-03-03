package com.jweekend.page;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.jweekend.HomePage;
import com.jweekend.WicketApplication;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class TestPage {
	
	private WicketTester tester;
	
	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}
	
	@Test
	public void testPage()
	{
		tester.startPage(HomePage.class);
		
		tester.assertRenderedPage(HomePage.class);
		
	}

}
