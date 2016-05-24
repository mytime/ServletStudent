package com.jkxy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkxy.model.stuInfo;

/**
 * 录入学生信息
 * form表单信息写入数据库
 * 
 */
public class stuInfoService {
	private Connection conn; // 连接数据库
	private PreparedStatement pstmt; // 预处理

	public stuInfoService() {
		// 实例化一个数据库连接
		conn = new com.jkxy.conn.conn().getCon();
	}

	/**
	 * 写入数据库
	 * 
	 * @param stu
	 *            form表单的实体类
	 * @return
	 */
	public boolean addStu(stuInfo stu) {
		String sql = "insert into studentinfo(nicheng,truename,xb,csrq,zy,kc,xq,bz)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stu.getNicheng());
			pstmt.setString(2, stu.getTruename());
			pstmt.setByte(3, stu.getXb());
			pstmt.setString(4, stu.getCsrq());
			pstmt.setString(5, stu.getZy());
			pstmt.setString(6, stu.getKcs());
			pstmt.setString(7, stu.getXqs());
			pstmt.setString(8, stu.getBz());

			pstmt.executeUpdate(); // 执行插入
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 查询所有学生信息 读出学生信息到表格
	 * 
	 * @return
	 */
	public List<stuInfo> queryAllStu() {
		List<stuInfo> stus = new ArrayList<stuInfo>();
		stuInfo stu; // 学生实体类

		String sql = "select * from studentinfo";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				stu = new stuInfo();
				stu.setId(rs.getInt(1));
				stu.setNicheng(rs.getString(2));
				stu.setTruename(rs.getString(3));
				stu.setXb(rs.getByte(4));
				if (rs.getDate(5) != null) {
					stu.setCsrq(rs.getDate(5).toString());
				}
				stu.setZy(rs.getString(6));
				if (rs.getString(7) != null) {
					stu.setKc(rs.getString(7).split("&"));
				}
				if (rs.getString(8) != null) {
					stu.setXq(rs.getString(8).split("&"));
				}
				stu.setBz(rs.getString(9));
				stus.add(stu);
			}
			return stus;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 根据ID查询学生信息
	 * 
	 * @return
	 */
	public stuInfo queryStuById(int id) {

		stuInfo stu; // 学生实体类

		String sql = "select * from studentinfo where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				stu = new stuInfo();
				stu.setId(rs.getInt(1));
				stu.setNicheng(rs.getString(2));
				stu.setTruename(rs.getString(3));
				stu.setXb(rs.getByte(4));
				if (rs.getDate(5) != null) {
					stu.setCsrq(rs.getDate(5).toString());
				}
				stu.setZy(rs.getString(6));
				if (rs.getString(7) != null) {
					stu.setKc(rs.getString(7).split("&"));
				}
				if (rs.getString(8) != null) {
					stu.setXq(rs.getString(8).split("&"));
				}
				stu.setBz(rs.getString(9));
				return stu;
			}
			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
	/**
	 * 更新学生信息
	 */
	public boolean updateStu(stuInfo stu){
		
		String sql = "update studentinfo set nicheng=? , truename=? , xb=? ,csrq=? ,"
				+ " zy=? ,kc=? , xq=?, bz=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getNicheng());
			pstmt.setString(2, stu.getTruename());
			pstmt.setByte(3, stu.getXb());
			pstmt.setString(4, stu.getCsrq());
			pstmt.setString(5, stu.getZy());
			pstmt.setString(6, stu.getKcs());
			pstmt.setString(7, stu.getXqs());
			pstmt.setString(8, stu.getBz());
			pstmt.setInt(9, stu.getId());
			pstmt.executeUpdate();
			return true;			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}		
	}
	/**
	 * 删除学生信息
	 * @param id
	 * @return Boolean
	 */
	public Boolean deleteStu(int id) {

		try {
			pstmt = conn.prepareStatement("delete from  studentinfo where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
