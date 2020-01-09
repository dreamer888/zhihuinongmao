/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */
package com.wqwy.zhnm.base.entity;

/**
 * createTime: 2018-05-05 17:58:46
 * 
 * @author seven
 * @version
 */
public class SysUser {

	/**
	 * 
	 */
	private String userId;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String rights;

	/**
	 * 
	 */
	private String roleId;

	/**
	 * 
	 */
	private String lastLogin;

	/**
	 * 
	 */
	private String ip;

	/**
	 * 
	 */
	private String status;

	/**
	 * 
	 */
	private String bz;

	/**
	 * 
	 */
	private String skin;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String number;

	/**
	 * 
	 */
	private String phone;

	public void setUserId(String value) {
		this.userId = value;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUsername(String value) {
		this.username = value;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setRights(String value) {
		this.rights = value;
	}

	public String getRights() {
		return this.rights;
	}

	public void setRoleId(String value) {
		this.roleId = value;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setLastLogin(String value) {
		this.lastLogin = value;
	}

	public String getLastLogin() {
		return this.lastLogin;
	}

	public void setIp(String value) {
		this.ip = value;
	}

	public String getIp() {
		return this.ip;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public String getStatus() {
		return this.status;
	}

	public void setBz(String value) {
		this.bz = value;
	}

	public String getBz() {
		return this.bz;
	}

	public void setSkin(String value) {
		this.skin = value;
	}

	public String getSkin() {
		return this.skin;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	public void setNumber(String value) {
		this.number = value;
	}

	public String getNumber() {
		return this.number;
	}

	public void setPhone(String value) {
		this.phone = value;
	}

	public String getPhone() {
		return this.phone;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", rights=" + rights + ", roleId=" + roleId + ", lastLogin=" + lastLogin + ", ip=" + ip + ", status="
				+ status + ", bz=" + bz + ", skin=" + skin + ", email=" + email + ", number=" + number + ", phone="
				+ phone + "]";
	}

}
