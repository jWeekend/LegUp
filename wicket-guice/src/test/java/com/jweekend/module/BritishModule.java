package com.jweekend.module;

import com.google.inject.AbstractModule;
import com.jweekend.service.HelloService;
import com.jweekend.service.impl.BritishHelloService;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class BritishModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(HelloService.class).to(BritishHelloService.class);

	}

}
