package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.bean.Power;
import com.oaoffice.dao.PowerDao;
import com.oaoffice.util.DbFun;

public class PowerDaoImpl implements PowerDao {
	@Override
	public List<Power> getPower(String uname) {
		List<Power> list = new ArrayList<Power>();
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	a.user_id,");
		sb.append("	a.user_name,");
		sb.append("	a.user_realname,");
		sb.append("	e.power_id,");
		sb.append("	e.power_name,");
		sb.append("  e.power_url,");
		sb.append("  e.power_pid,");
		sb.append("	 c.role_id,");
		sb.append("  e.power_ismenu,");
		sb.append("  e.key	");
		sb.append("FROM");
		sb.append("	user as a");
		sb.append("	LEFT JOIN user_role b ON a.user_id = b.user_id");
		sb.append("	LEFT JOIN role c ON b.role_id = c.role_id");
		sb.append("	LEFT JOIN power_role d ON c.role_id = d.role_id");
		sb.append("	LEFT JOIN power e ON d.powerrole_id = e.power_id ");
		sb.append("	where a.user_name='" + uname + "' ");
		String sql = sb.toString();
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Power tmpbean = null;
			while (rs.next()) {
				tmpbean = new Power();
				// tmpbean.setId(rs.getInt("id"));
				// tmpbean.setUname(rs.getString("uname"));
				// tmpbean.setRealname(rs.getString("realname"));
				tmpbean.setPower_id(rs.getInt("power_id"));
				tmpbean.setPower_name(rs.getString("power_name"));
				tmpbean.setPower_url(rs.getString("power_url"));
				tmpbean.setPower_pid(rs.getInt("power_pid"));
				tmpbean.setPower_ismenu(rs.getString("power_ismenu"));
				tmpbean.setKey(rs.getString("key"));
				tmpbean.setRole_id(rs.getInt("role_id"));
				list.add(tmpbean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;

	}

	@Override
	public List<Power> list() {
		List<Power> list = new ArrayList<Power>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from power ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Power tmpbean = null;
			while (rs.next()) {
				tmpbean = new Power();
				// tmpbean.setId(rs.getInt("id"));
				// tmpbean.setUname(rs.getString("uname"));
				// tmpbean.setRealname(rs.getString("realname"));
				tmpbean.setPower_id(rs.getInt("power_id"));
				tmpbean.setPower_name(rs.getString("power_name"));
				tmpbean.setPower_url(rs.getString("power_url"));
				tmpbean.setPower_pid(rs.getInt("power_pid"));
				tmpbean.setPower_ismenu(rs.getString("power_ismenu"));
				tmpbean.setKey(rs.getString("key"));

				list.add(tmpbean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;
	}

}
