package com.jweekend.config.modules;

import com.google.inject.AbstractModule;
import com.jweekend.DataInitialiser;
import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dao.jpa.EventDaoJPAImp;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;
import com.wideplay.warp.persist.jpa.JpaUnit;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
public class Module extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		if(initData())
		{
			bind(DataInitialiser.class).asEagerSingleton();
		}

		//warp persist stuff
		install(PersistenceService.usingJpa()
				.across(UnitOfWork.REQUEST)
				.buildModule());

		//dao stuff
		bind(EventDao.class).to(EventDaoJPAImp.class);

		bindConstant().annotatedWith(JpaUnit.class).to("myFirstJpaUnit");
	}

	/**
	 * Should the data initialisation step be run?  This populates data in the database
	 *
	 * @return true or false
	 */
	protected boolean initData()
	{
		return true;
	}

}
