package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.MeetingRoom;
import com.oaoffice.dao.MeetingRoomDao;
import com.oaoffice.dao.impl.MeetingRoomDaoImpl;
import com.oaoffice.service.MeetingRoomService;
import com.oaoffice.util.PagingVO;

public class MeetingRoomServiceImpl implements MeetingRoomService {
	private MeetingRoomDao Meetingdao = new MeetingRoomDaoImpl();

	@Override
	public Integer insert(MeetingRoom bean) {
		// TODO Auto-generated method stub
		return Meetingdao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.delete(id);
	}

	@Override
	public Integer update(MeetingRoom bean) {
		// TODO Auto-generated method stub
		return Meetingdao.update(bean);
	}

	@Override
	public List<MeetingRoom> list() {
		// TODO Auto-generated method stub
		return Meetingdao.list();
	}

	@Override
	public MeetingRoom load(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return Meetingdao.count();
	}

	@Override
	public MeetingRoom loadByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.countByName(name);
	}

	@Override
	public MeetingRoom loadByNo(String no) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByNo(no);
	}

	@Override
	public List<MeetingRoom> listByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.listByName(name);
	}

	@Override
	public List<MeetingRoom> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return Meetingdao.queryAll(page);
	}

	@Override
	public MeetingRoom getMeetingRoom(MeetingRoom stu) {
		// TODO Auto-generated method stub
		return Meetingdao.getMeetingRoom(stu);
	}

}
