package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.bean.*;
import com.oaoffice.dao.PowerDao;
import com.oaoffice.util.DbFun;

public class PowerDaoImpl implements PowerDao {

	@Override
	public List<Power> list() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT  u.user_id,u.user_realname,quan.role_name,GROUP_CONCAT(quan.power_name)as power_name ");
		sb.append(" FROM user u LEFT JOIN ");
		sb.append(" (SELECT ur.user_id,rprp.role_name,rprp.power_name ");
		sb.append(" FROM user_role ur LEFT JOIN ");
		sb.append(" (SELECT rpr.role_id,rpr.role_name, p.power_name ");
		sb.append(" from (SELECT r.role_name,pr.powerrole_id,r.role_id ");
		sb.append(" from role r LEFT JOIN power_role pr ");
		sb.append(" on r.role_id=pr.role_id) as rpr ");
		sb.append(" LEFT JOIN power p ");
		sb.append(" on rpr.powerrole_id =p.power_id) as rprp ");
		sb.append(" ON ur.role_id =rprp.role_id)AS quan ");
		sb.append(" ON u.user_id =quan.user_id ");
		sb.append(" GROUP BY u.user_id,u.user_realname,quan.role_name ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Power> list = new ArrayList<Power>();
		Power bean = null;

		try {
			conn = DbFun.getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				bean = new Power();
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_realname(rs.getString("user_realname"));
				bean.setRole_name(rs.getString("role_name"));
				bean.setPower_name(rs.getString("power_name"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return list;
	}

	@Override
	public User_Role loadByid(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select u.user_realname,urr.* ");
		sb.append(" FROM user u LEFT JOIN ");
		sb.append(" (select ur.*,r.role_name ");
		sb.append(" from  user_role ur LEFT JOIN role r on ur.role_id=r. ");
		sb.append(" role_id)AS urr ");
		sb.append(" ON u.user_id =urr.user_id  ");
		sb.append(" WHERE u.user_id = ? ");
		String sql = sb.toString();
		User_Role bean = null;

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		conn = DbFun.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setObject(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				bean = new User_Role();
				bean.setRole_id(rs.getString("role_id"));
				bean.setRole_name(rs.getString("role_name"));
				bean.setUser_realname(rs.getString("user_realname"));
				bean.setUser_id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return bean;
	}

	@Override
	public List<Role> listByRole() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from role  ");
		String sql = sb.toString();
		List<Role> list = new ArrayList<Role>();
		Role bean = null;

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				bean = new Role();
				bean.setRole_id(rs.getString("role_id"));
				bean.setRole_name(rs.getString("role_name"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return list;
	}

	@Override
	public Integer updete(User_Role bean) {
		StringBuilder sb = new StringBuilder();
		sb.append(" update user_role  set  ");
		sb.append(" role_id = ? ");
		sb.append(" where user_id = ? ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pst = null;
		Integer num = 0;

		conn = DbFun.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setObject(1, bean.getRole_id());
			pst.setObject(2, bean.getUser_id());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return num;
	}

	private StringBuilder StringBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Power_Role> listPower_Role(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT r.role_name,prp.* ");
		sb.append(" from role r  ");
		sb.append(" LEFT JOIN (select pr.*,p.power_name ");
		sb.append(" From power_role pr ");
		sb.append(" LEFT JOIN power p ");
		sb.append(" on pr.powerrole_id =p.power_id)as prp ");
		sb.append(" on r.role_id=prp.role_id ");
		sb.append(" WHERE r.role_id = ? ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Power_Role> list = new ArrayList<Power_Role>();
		Power_Role bean = null;

		conn = DbFun.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setObject(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				bean = new Power_Role();
				bean.setPower_id(rs.getString("powerrole_id"));
				bean.setPower_name(rs.getString("power_name"));
				bean.setRole_id(rs.getString("role_id"));
				bean.setRole_name(rs.getString("role_name"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return list;
	}

	@Override
	public List<Power_Role> listPower() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT power_id,power_name FROM power ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Power_Role> list = new ArrayList<Power_Role>();
		Power_Role bean = null;

		conn = DbFun.getConn();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				bean = new Power_Role();
				bean.setPower_id(rs.getString("power_id"));
				bean.setPower_name(rs.getString("power_name"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return list;
	}

	@Override
	public Integer delete(String role_id, String power_id) {
		StringBuilder sb =new StringBuilder();
		sb.append("delete from power_role where role_id = ? and powerrole_id = ?");
		String sql = sb.toString();
		Connection conn = null;
		PreparedStatement pst = null;
		Integer num = 0;
		
		conn=DbFun.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setObject(1, role_id);
			pst.setObject(2, power_id);
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbFun.close(null, pst, conn);
		}
		return num;
	}

	@Override
	public Integer insert(String role_id, String power_id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into power_role(role_id,powerrole_id) ");
		sb.append(" values(?,?) ");
		String sql = sb.toString();
		Connection conn=null;
		PreparedStatement pst= null;
		Integer num =0;
		conn = DbFun.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setObject(1, role_id);
			pst.setObject(2, power_id);
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbFun.close(null, pst, conn);
		}
		return num;
	}

}
