package com.jweekend.spring;

import com.jweekend.DataInitialiser;
import com.jweekend.data.dao.interfaces.EventDao;
import com.jweekend.data.dao.jpa.EventDaoJPAImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class Config
{
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setPersistenceUnitName("myFirstJpaUnit");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return factoryBean;
	}

	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public EventDao eventDaoJPA() {
		return new EventDaoJPAImp();
	}

	@Bean
	public DataInitialiser dataInitialiser() {
		DataInitialiser initialiser = new DataInitialiser();
		initialiser.setEventDao(eventDaoJPA());
		initialiser.dataInit();
		return initialiser;
	}
}
