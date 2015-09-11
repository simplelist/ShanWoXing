package com.yxtar.server.dao;

import java.io.Serializable;

import com.yxtar.server.util.ListResult;

public interface BaseDao<M extends Serializable, K extends Serializable> {
	public K save(M model);

	public ListResult<M> getList(IPager pager, String dtoName);

	public void saveOrUpdate(M model);

	public void update(M model);

	public void deleteObject(M model);

	public void delete(K id);

	public M get(K id);

}
