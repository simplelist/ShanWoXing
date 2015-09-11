package com.yxtar.server.service;

import java.io.Serializable;

public interface BaseService<M extends Serializable, K extends Serializable> {
	public K save(M model);

	public void saveOrUpdate(M model);

	public void update(M model);

	public void delete(K id);

	public void deleteObject(M model);

	public M get(K id);
}
