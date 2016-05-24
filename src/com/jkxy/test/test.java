package com.jkxy.test;

import com.jkxy.conn.conn;
/**
 * 测试数据库连接
 *
 */
public abstract class test {

	public static void main(String[] args) {
		//测试数据库连接
		new conn().getCon();
	}

}
