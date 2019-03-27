package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.Meeting;
import com.oaoffice.dao.MeetingDao;
import com.oaoffice.dao.impl.MeetingDaoImpl;
import com.oaoffice.service.MeetingService;
import com.oaoffice.util.PagingVO;

public class MeetingServiceImpl implements MeetingService {
	private MeetingDao Meetingdao = new MeetingDaoImpl();

	@Override
	public Integer insert(Meeting bean) {
		// TODO Auto-generated method stub
		return Meetingdao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.delete(id);
	}

	@Override
	public Integer update(Meeting bean) {
		// TODO Auto-generated method stub
		return Meetingdao.update(bean);
	}

	@Override
	public List<Meeting> list() {
		// TODO Auto-generated method stub
		return Meetingdao.list();
	}

	@Override
	public Meeting load(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return Meetingdao.count();
	}

	@Override
	public Meeting loadByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.countByName(name);
	}

	@Override
	public Meeting loadByNo(String no) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByNo(no);
	}

	@Override
	public List<Meeting> listByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.listByName(name);
	}

	@Override
	public List<Meeting> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return Meetingdao.queryAll(page);
	}

	@Override
	public Meeting getMeeting(Meeting stu) {
		// TODO Auto-generated method stub
		return Meetingdao.getMeeting(stu);
	}

}
