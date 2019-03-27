package com.oaoffice.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.*;
import com.oaoffice.dao.*;
import com.oaoffice.util.PagingVO;

public class MeetingapplyDaoImpl implements MeetingapplyDao {

	@SuppressWarnings("resource")
	@Override
	public Integer insert(Meetingapply bean) {

		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Meetingapply(meetingapply_time,meetingapply_reason,user_id,");
		sb.append(" approver,meetingapply_state,role_id)");
		sb.append("Values(?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getMeetingapply_time());
			pstmt.setObject(2, bean.getMeetingapply_reason());
			pstmt.setObject(3, bean.getUser_id());
			pstmt.setObject(4, bean.getApprover());
			pstmt.setObject(5, bean.getMeetingapply_state());
			pstmt.setObject(6, bean.getRole_id());

			num = pstmt.executeUpdate();

			// 如果受影响行数大于0，说明添加成功；之后，要获取刚刚添加的行的主键值
			if (num > 0) {
				sql = "Select @@Identity";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					num = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	@Override
	public List<Meetingapply> list() {
		List<Meetingapply> list = new ArrayList<Meetingapply>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.meetingapply_id,");
		sb.append("	b.meetingapply_time,");
		sb.append("	b.meetingapply_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.meetingapply_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN meetingapply b ON a.user_id = b.user_id ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Meetingapply tmpbean = null;
			while (rs.next()) {
				tmpbean = new Meetingapply();
				tmpbean.setMeetingapply_id(rs.getInt("meetingapply_id"));
				tmpbean.setMeetingapply_time(rs.getDate("meetingapply_time"));
				tmpbean.setMeetingapply_reason(rs.getString("meetingapply_reason"));
				tmpbean.setUser_id(rs.getInt("user_id"));
				tmpbean.setApprover(rs.getString("approver"));
				tmpbean.setMeetingapply_state(rs.getString("meetingapply_state"));
				tmpbean.setRole_id(rs.getInt("role_id"));
				tmpbean.setUser_realname(rs.getString("user_realname"));

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
	public Integer delete(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from Meetingapply where Meetingapply_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	@Override
	public Integer update(Meetingapply bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Meetingapply Set ");
		sb.append(" meetingapply_time=? ");
		sb.append(" ,meetingapply_reason=? ");
		sb.append(" ,user_id=? ");
		sb.append(" ,approver=? ");
		sb.append(" ,meetingapply_state=? ");
		sb.append(" ,role_id=? ");
		sb.append(" where meetingapply_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;
		// uname,upass,realName,gender,birthday
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			show(bean, pstmt);

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}
	
	@Override
	public Meetingapply load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.meetingapply_id,");
		sb.append("	b.meetingapply_time,");
		sb.append("	b.meetingapply_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.meetingapply_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN meetingapply b ON a.user_id = b.user_id ");
		sb.append(" Where Meetingapply_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Meetingapply bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Meetingapply();

				show(rs, bean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return bean;
	}

	@Override
	public Integer count() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Meetingapply");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	@Override
	public Meetingapply loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meetingapply loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meetingapply");
		sb.append(" Where Meetingapply_time=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Meetingapply bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Meetingapply();

				show(rs, bean);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return bean;
	}

	@Override
	public List<Meetingapply> listByName(String name) {
		List<Meetingapply> list = new ArrayList<Meetingapply>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.meetingapply_id,");
		sb.append("	b.meetingapply_time,");
		sb.append("	b.meetingapply_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.meetingapply_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN meetingapply b ON a.user_id = b.user_id ");
		sb.append(" where Meetingapply_time like ?");
		String sql = sb.toString();

		name = "%" + name + "%";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, name);

			rs = pstmt.executeQuery();

			Meetingapply tmpbean = null;
			while (rs.next()) {
				tmpbean = new Meetingapply();
				show(tmpbean, rs);

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
	public List<Meetingapply> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Meetingapply> list = new ArrayList<Meetingapply>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meetingapply limit ?,?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			Meetingapply tmpbean = null;

			while (rs.next()) {
				tmpbean = new Meetingapply();
				show(tmpbean, rs);
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
	public Meetingapply getMeetingapply(Meetingapply stu) {
		Meetingapply tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meetingapply");
		sb.append(" where Meetingapply_time=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getMeetingapply_time());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Meetingapply();
				show(tmpbean, rs);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return tmpbean;
	}

	private void show(Meetingapply bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getMeetingapply_time());
		pstmt.setObject(2, bean.getMeetingapply_reason());
		pstmt.setObject(3, bean.getUser_id());
		pstmt.setObject(4, bean.getApprover());
		pstmt.setObject(5, bean.getMeetingapply_state());
		pstmt.setObject(6, bean.getRole_id());
		pstmt.setObject(7, bean.getMeetingapply_id());
	}

	private void show(Meetingapply tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setMeetingapply_id(rs.getInt("meetingapply_id"));
		tmpbean.setMeetingapply_time(rs.getDate("meetingapply_time"));
		tmpbean.setMeetingapply_reason(rs.getString("meetingapply_reason"));
		tmpbean.setUser_id(rs.getInt("user_id"));
		tmpbean.setApprover(rs.getString("approver"));
		tmpbean.setMeetingapply_state(rs.getString("meetingapply_state"));
		tmpbean.setRole_id(rs.getInt("role_id"));
		tmpbean.setUser_realname(rs.getString("user_realname"));
	}

	private void show(ResultSet rs, Meetingapply bean) throws SQLException {
		bean.setMeetingapply_id(rs.getInt("meetingapply_id"));
		bean.setMeetingapply_time(rs.getDate("meetingapply_time"));
		bean.setMeetingapply_reason(rs.getString("meetingapply_reason"));
		bean.setUser_id(rs.getInt("user_id"));
		bean.setApprover(rs.getString("approver"));
		bean.setMeetingapply_state(rs.getString("meetingapply_state"));
		bean.setRole_id(rs.getInt("role_id"));
		bean.setUser_realname(rs.getString("user_realname"));
	}

}
