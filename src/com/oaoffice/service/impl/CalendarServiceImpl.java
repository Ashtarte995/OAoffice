package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Calendar;
import com.oaoffice.dao.CalendarDao;
import com.oaoffice.dao.impl.CalendarDaoImpl;
import com.oaoffice.service.CalendarService;
import com.oaoffice.util.PagingVO;

public class CalendarServiceImpl implements CalendarService{
	private CalendarDao Calendardao=new CalendarDaoImpl();
	
	@Override
	public Integer insert(Calendar bean) {
		// TODO Auto-generated method stub
		return Calendardao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return Calendardao.delete(id);
	}

	@Override
	public Integer update(Calendar bean) {
		// TODO Auto-generated method stub
		return Calendardao.update(bean);
	}

	@Override
	public List<Calendar> list() {
		// TODO Auto-generated method stub
		return Calendardao.list();
	}

	@Override
	public Calendar load(Integer id) {
		// TODO Auto-generated method stub
		return Calendardao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return Calendardao.count();
	}

	@Override
	public Calendar loadByName(String name) {
		// TODO Auto-generated method stub
		return Calendardao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return Calendardao.countByName(name);
	}

	@Override
	public Calendar loadByNo(String no) {
		// TODO Auto-generated method stub
		return Calendardao.loadByNo(no);
	}

	@Override
	public List<Calendar> listByName(String name) {
		// TODO Auto-generated method stub
		return Calendardao.listByName(name);
	}

	@Override
	public List<Calendar> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return Calendardao.queryAll(page);
	}

	@Override
	public Calendar getCalendar(Calendar stu) {
		// TODO Auto-generated method stub
		return Calendardao.getCalendar(stu);
	}

}
