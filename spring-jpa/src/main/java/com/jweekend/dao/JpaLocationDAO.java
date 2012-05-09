package com.jweekend.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.jweekend.dao.interfaces.LocationDao;
import com.jweekend.entity.Location;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 *
 */
@Transactional
public class JpaLocationDAO extends CommonDao<Location, Long> implements LocationDao {

	public JpaLocationDAO() {
		super(Location.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.jweekend.dao.interfaces.Dao#countAll()
	 */
	public int countAll() {
		TypedQuery<Long> query = getEntityManager().createQuery("select count(l) from Location l", Long.class);
		return query.getSingleResult().intValue();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.jweekend.dao.interfaces.Dao#findAll()
	 */
	public List<Location> findAll() {
		TypedQuery<Location> query = getEntityManager().createQuery("select l from Location l", Location.class);
		return query.getResultList();
	}

}
