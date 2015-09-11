package com.yxtar.server.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yxtar.app.shared.TestCassandra;

@Service
public interface TestCassandraService {
	/**
	 * save files
	 * 
	 * @param test
	 * @return
	 */
	public Boolean save(TestCassandra test);

	/**
	 * delete files
	 * 
	 * @param idlist
	 * @return
	 */
	public Boolean delete(TestCassandra idlist);

	/**
	 * Batch update files list
	 * 
	 * @param list
	 * @return
	 */
	public Boolean update(List<TestCassandra> list);

	/**
	 * find files by id
	 * 
	 * @param id
	 * @return
	 */
	public TestCassandra findById(UUID id);

	public List<TestCassandra> findAll();

}
