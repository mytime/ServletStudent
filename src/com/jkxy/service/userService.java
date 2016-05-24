package com.jkxy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jkxy.model.userTable;

/**
 * 
 * 查询
 * 验证用户是否合法
 *
 */
public class userService {
	private Connection conn;
	private PreparedStatement pstmt;

	public userService() {
		//实例化一个数据库连接
		conn = new com.jkxy.conn.conn().getCon();
	}

	public boolean valiUser(userTable user)
	{
		
		String sql = "select * from usertable where username =? and password=?";
		try {
			//预声明一个SQL查询
			pstmt=conn.prepareStatement(sql);
			//两个占位符？ 对应的值
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			//查询结果集
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) //非空
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
