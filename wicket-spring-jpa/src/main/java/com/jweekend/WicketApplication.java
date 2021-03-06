package com.jweekend;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.jweekend.pages.EventPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class WicketApplication extends WebApplication
{
	protected SpringComponentInjector getSpringInjector()
	{
		return new SpringComponentInjector(this);
	}

	@Override
	protected void init() {
		super.init();

		mountPage("event", EventPage.class);

		getComponentInstantiationListeners().add(getSpringInjector());
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
