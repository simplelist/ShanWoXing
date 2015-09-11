package com.yxtar.server.service.impl;

import java.io.Serializable;

import com.yxtar.server.dao.BaseDao;
import com.yxtar.server.service.BaseService;

public abstract class BaseServiceImpl<M extends Serializable, K extends Serializable> implements BaseService<M, K> {
	protected BaseDao<M, K> baseDao;

	public abstract void setBaseDao(BaseDao<M, K> baseDao);

	@Override
	public K save(M model) {
		return baseDao.save(model);
	}

	@Override
	public void saveOrUpdate(M model) {
		baseDao.saveOrUpdate(model);
	}

	@Override
	public void update(M model) {
		baseDao.update(model);
	}

	@Override
	public void delete(K id) {
		baseDao.delete(id);
	}

	@Override
	public void deleteObject(M model) {
		baseDao.deleteObject(model);
	}

	@Override
	public M get(K id) {
		return baseDao.get(id);
	}

}
