package com.jweekend.config.modules;

import org.hibernate.cfg.Configuration;

import com.google.inject.AbstractModule;
import com.jweekend.DataInitialiser;
import com.jweekend.data.dao.hibernate.EventDaoHibernateImp;
import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dataobjects.Event;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;

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
		install(PersistenceService.usingHibernate()
				.across(UnitOfWork.REQUEST)
				.buildModule());

		////hibernate stuff
		Configuration annotationConfiguration = new Configuration();
		annotationConfiguration.configure();
		annotationConfiguration.addAnnotatedClass(Event.class);
		bind(Configuration.class).toInstance(annotationConfiguration);

		//dao stuff
		bind(EventDao.class).to(EventDaoHibernateImp.class);
	}

	protected boolean initData()
	{
		return true;
	}

}
