package com.yxtar.server.dto;

public interface StrategyMap {

	/**
	 * transcate a dto to json object
	 * 
	 * @return json object
	 */
	public Object generateMap();

	/**
	 * transcate a dto to json object
	 * 
	 * @return json object with special language part
	 */
	// public Object generateMap(Integer langid);

}
