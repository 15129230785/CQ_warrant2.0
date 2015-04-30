package com.cq.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cq.util.WarrantException;

public abstract class BaseDao<T> extends HibernateDaoSupport implements DAO<T>{
	protected Logger log = Logger.getLogger(getClass());
	String errorMsg;
	
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}
	
	public void update(T bean) {
		getHibernateTemplate().update(bean);
	}
	
	public Serializable save (T bean) {
		return getHibernateTemplate().save(bean);
	}
	
	public void delete (Serializable id) {
		getHibernateTemplate().delete(get(id));
	}
	
	public void deleteAll (Collection<?> list) {
		getHibernateTemplate().deleteAll(list);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return (List<T>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(getEntityClass()));
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriterias(DetachedCriteria criteria) {
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriterias(DetachedCriteria criteria, int first, int max) {
		return (List<T>) getHibernateTemplate().findByCriteria(criteria, first, max);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property, Object value) {
		return (List<T>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(getEntityClass())
					.add(Restrictions.eq(property, value)));
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByWildProperty(String property, String value) {
		return (List<T>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(getEntityClass())
					.add(Restrictions.ilike(property, value, MatchMode.ANYWHERE)));
	}
	
	@SuppressWarnings("unchecked")
	public T findOnlyByProperty(String property, Object value) {
		T bean = null;
		List<T> list = null;
		list =  getHibernateTemplate()
					.findByCriteria(DetachedCriteria.forClass(getEntityClass())
						.add(Restrictions.eq(property, value)));
		if (list != null && list.size() > 0) {
			bean = list.get(0);
		}
		return bean;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql) {
		return getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public int countAll() {
		int count = 0;
		List<T> list = null;
		
		list = getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(getEntityClass())
					.setProjection(Projections.rowCount()), 0, 1);
		if (list != null && list.size() == 1) {
			count = ((Number) list.get(0)).intValue();
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public int countByCriterias(DetachedCriteria dc) {
		int count = 0;
		List<T> list = null;
		
		dc.setProjection(Projections.rowCount());
		list = getHibernateTemplate().findByCriteria(dc, 0, 1);
		if (list != null && list.size() == 1) {
			count = ((Number) list.get(0)).intValue();
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public double sumByProperty(String property) {
		List<Object> list = null;
		Object o = null;
		
		list = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(getEntityClass())
				.setProjection(Projections.sum(property)), 0, 1);
		if (list != null && list.size() == 1) {
			o = list.get(0);
			if (o == null) {
				return 0;
			}
			return ((Number)o).doubleValue();
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public double sumByCriterias(DetachedCriteria dc) {
		List<Object> list = null;
		Object o = null;
		
		list = getHibernateTemplate().findByCriteria(dc, 0, 1);
		if (list != null && list.size() == 1) {
			o = list.get(0);
			if (o == null) {
				return 0;
			}
			return ((Number)o).doubleValue();
		}
		return 0;
	}
	
	//abstract protected Class<T> getEntityClass();
	public Class getEntityClass() {
		Type genType = getClass().getGenericSuperclass();// 得到泛型父类
		// 如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		//返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class,
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (0 >= params.length) {
			errorMsg = "你输入的索引超出了参数的总数";
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		if (!(params[0] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[0];
	}

}
