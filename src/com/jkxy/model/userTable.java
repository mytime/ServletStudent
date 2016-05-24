package com.jkxy.model;
/**
 * 登录用户实体类
 * user数据表的映射类 * 
 * 模型类
 */
public class userTable {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//模式是无参的构造方法
}
