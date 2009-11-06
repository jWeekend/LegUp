package com.jweekend.service.impl;

import com.jweekend.service.HelloService;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class GermanHelloService implements HelloService {

	/* (non-Javadoc)
	 * @see com.jweekend.service.HelloService#sayGoodbye(java.lang.String)
	 */
	public String sayGoodbye(String name) {
		return "Auf Wiedersehen " + name;
	}

	/* (non-Javadoc)
	 * @see com.jweekend.service.HelloService#sayHello(java.lang.String)
	 */
	public String sayHello(String name) {
		return "Hallo " + name;
	}

}
