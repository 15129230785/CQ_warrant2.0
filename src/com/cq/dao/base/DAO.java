package com.cq.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface DAO<T> {
	public T get(Serializable id);
	
	public void update(T bean);
	
	public Serializable save (T bean);
	
	public void delete (Serializable id);
	
	public void deleteAll (Collection<?> list);
	
	public List<T> list();
	
	public List<T> findByCriterias(DetachedCriteria criteria);
	
	public List<T> findByCriterias(DetachedCriteria criteria, int first, int max);
	
	public List<T> findByProperty(String property, Object value);
	
	public List<T> findByWildProperty(String property, String value);
	
	public List<T> findByHql(String hql);
	
	public T findOnlyByProperty(String property, Object value);
	
	public int countAll();
	
	public int countByCriterias(DetachedCriteria dc);
	
	public double sumByProperty(String property);
	
	public double sumByCriterias(DetachedCriteria dc);
}
