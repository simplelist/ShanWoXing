package com.yxtar.server.dao;

import java.util.Map;

public interface IPager {
	public abstract Integer getLimit();

	/**
	 * current page
	 * @return
	 */
	public Integer getCurrentPage();

	/**
	 * desc or asc
	 * 正序或倒序
	 * @return
	 */
	public String getSortAscOrDesc();

	/**
	 * 根据哪个字段来排序
	 * @return
	 */
	public String getOrderBy();

	/**
	 * 查询条件
	 * @return
	 */
	public Map getParams();

	public Integer getStart();

	public void setPage(Integer currentPage);

	public void setLimit(Integer max);

	public void setSort(String field);

	public void setOrder(String desc);

	public void setParams(Map<String, Object> map);

}
