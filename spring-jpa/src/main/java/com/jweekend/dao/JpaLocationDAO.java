package com.jweekend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.LocationDao;
import com.jweekend.entity.Location;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
@Transactional
public class JpaLocationDAO extends CommonDao<Location> implements LocationDao {

	/**
	 * @param clazz
	 */
	public JpaLocationDAO() {
		super(Location.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#countAll()
	 */
	public int countAll() {
		return ((Long) getJpaTemplate().execute(new JpaCallback() {

			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query query = em.createQuery("select count(l) from Location l");
				return query.getSingleResult();
			}
		})).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jweekend.dao.interfaces.Dao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Location> findAll() {
		return getJpaTemplate().find("select l from Location l");
	}

}
