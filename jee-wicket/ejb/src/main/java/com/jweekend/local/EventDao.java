package com.jweekend.local;

import javax.ejb.Local;

import com.jweekend.dataobjects.Event;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 */
@Local
public interface EventDao extends Dao<Event> {

}
