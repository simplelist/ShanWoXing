package com.yxtar.server.cassandra.dao;

public class CassandraConnParam {
	/**
	 * IP地址
	 */
	private String contactPoints=null;
	/**
	 * 端口号
	 */
	private String port = null;
	/**
	 * 用户名
	 */
	private String userName = null;
	/**
	 * 密码
	 */
	private String passWord = null;
	/**
	 * 密钥
	 */
	private String keySpace = null;
	
	public String getContactPoints() {
		return contactPoints;
	}
	public void setContactPoints(String contactPoints) {
		this.contactPoints = contactPoints;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getKeySpace() {
		return keySpace;
	}
	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}
	
	
}
