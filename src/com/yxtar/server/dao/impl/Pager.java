package com.yxtar.server.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.yxtar.server.dao.IPager;

public class Pager implements IPager {

	private Integer page;
	private String sort;
	private String order;
	private Integer rows;
	private Map params = new HashMap();

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	@Override
	public Integer getLimit() {
		return rows; 
	}

	@Override
	public Integer getCurrentPage() {
		return page; 
	}

	@Override
	public String getSortAscOrDesc() {
		return sort; 
	}

	@Override
	public String getOrderBy() {
		return order; 
	}

	@Override
	public Map getParams() {
		return params; 
	}

	@Override
	public Integer getStart() {
		if (getLimit() != null && getCurrentPage() != null) {
			return (getCurrentPage() - 1) * getLimit();
		}
		return 0; 
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public void setParams(Map<String, Object> map) {
		this.params=map;
	}


	@Override
	public void setLimit(Integer max) {
		this.rows=max;
	}

}