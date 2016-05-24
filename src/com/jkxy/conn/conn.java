package com.jkxy.conn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 * 
 */
public class conn {
	public Connection getCon() {
		try {
			// 加载jdbc驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 链接数据库
			String url = "jdbc:mysql://localhost/jkxystudent?useUnicode=true&"
					+ "characterEncoding=utf-8";
			String user = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);
			//测试连接
			System.out.println(conn.getMetaData().getURL());
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
