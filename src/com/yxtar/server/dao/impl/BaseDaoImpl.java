package com.yxtar.server.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.yxtar.app.base.utility.ValidationUtil;
import com.yxtar.server.dao.BaseDao;
import com.yxtar.server.dao.IPager;
import com.yxtar.server.util.ListResult;

/**
 * The Class BaseDaoImpl.
 *
 * @param <M>
 *            the generic type
 * @param <K>
 *            the key type
 */
@Repository("baseDao")
public abstract class BaseDaoImpl<M extends Serializable, K extends Serializable> extends HibernateDaoSupport implements BaseDao<M, K> {
	protected StringBuilder hql;
	protected Query query;
	protected Query countQuery;
	protected Map<Integer, Object> paramsMap;
	protected ListResult<M> listResult;
	protected List<M> result;
	protected Integer resultCount=0;
	protected ValidationUtil validationUtil=ValidationUtil.getInstance();
	/** The entity class. */
	private final Class<M> entityClass;

	/**
	 * Instantiates a new base dao impl.
	 */
	protected BaseDaoImpl() {
		this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		Session session = null;
		try {
			session = getSessionFactory().getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
			session = getSessionFactory().openSession();
		}
		return session;
	}


	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */

	/**
	 * Sets the session factory.
	 *
	 * @param getSessionFactory()
	 *            the new session factory
	 */

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the m
	 */
	@Override
	public M get(K id) {
		return (M) getSession().get(entityClass, id);
	}

	@Override
	public K save(M model) {
		return (K) getSession().save(model);
	}

	@Override
	public void delete(K id) {
		getSession().delete(get(id));
	}

	/**
	 * Save or update.
	 *
	 * @param model
	 *            the model
	 */
	@Override
	public void saveOrUpdate(M model) {
		getSession().saveOrUpdate(model);
	}

	/**
	 * Update.
	 *
	 * @param model
	 *            the model
	 */
	@Override
	public void update(M model) {
		getSession().update(model);
	}

	/**
	 * Delete object.
	 *
	 * @param model
	 *            the model
	 */
	@Override
	public void deleteObject(M model) {
		getSession().delete(model);
	}
	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public ListResult<M> getList(IPager pager,String dtoName) {
		initParameters(dtoName);
		if (pager != null) {
			/**
			 * 条件
			 */
			if (pager.getParams() != null && !pager.getParams().isEmpty()) {
				int keyCount = 0;
				for (Object key : pager.getParams().keySet()) {
					if (pager.getParams().get(key) != null) {
						hql.append(" and " + key + " = ? ");
						paramsMap.put(keyCount, pager.getParams().get(key));
						keyCount++;
					}
				}
			}

		}

		countQuery = getSession().createQuery("select count(*) " + hql.toString());
		/**
		 * 添加参数,根据parameters
		 */
		setQueryParameters(countQuery,paramsMap);
		/**
		 * 分页查询 起始页:setFirstResult(pager.getStart()) 最多多少条:setMaxResults(pager.getLimit()
		 */
		resultCount = ((Long) countQuery.uniqueResult()).intValue();
		listResult.setCount(resultCount);

		/**
		 * order by
		 */
		if (pager != null) {
			if (pager.getOrderBy() != null) {
				hql.append(" order by " + pager.getOrderBy());
				if (pager.getSortAscOrDesc() != null) {
					hql.append(" " + pager.getSortAscOrDesc());
				}
			}
		}
		/**
		 * 添加参数,根据parameters
		 */
		query = getSession().createQuery(hql.toString());
		setQueryParameters(query,paramsMap);
		try {
			if (pager.getStart()!=null) {
				query.setFirstResult(pager.getStart());
			}
			if (pager.getLimit()!=null) {
				query.setMaxResults(pager.getLimit());
			}
			result = query.list();
			listResult.setDataList(result);
			return listResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	/**
	 * 添加参数,根据parameters
	 */
	public Query setQueryParameters(Query squery, Map<Integer, Object> sparamsMap) {
		if (squery != null && sparamsMap != null) {
			for (Integer i : sparamsMap.keySet()) {
				if (sparamsMap.get(i) != null) {
					squery.setParameter(i, sparamsMap.get(i));
				}
			}
		}
		return squery;
	}
	
	public void initParameters(String className){
		hql = new StringBuilder("from " + className + " where  0=0 ");
		paramsMap = new HashMap<Integer, Object>();
		listResult = new ListResult<M>();
		result = new ArrayList<M>();
	}
}
