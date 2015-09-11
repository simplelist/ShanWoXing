package com.yxtar.server.cassandra.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CassandraConnParam {
	/**
	 * ID������
	 */
	private String contactPoints=null;
	/**
	 * ���������
	 */
	private String port = null;
	/**
	 * ���������
	 */
	private String userName = null;
	/**
	 * ������
	 */
	private String passWord = null;
	/**
	 * ������
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
