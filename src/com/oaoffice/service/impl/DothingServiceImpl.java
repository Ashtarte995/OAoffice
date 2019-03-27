package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Dothing;
import com.oaoffice.dao.DothingDao;
import com.oaoffice.dao.impl.DothingDaoImpl;
import com.oaoffice.service.DothingService;
import com.oaoffice.util.PagingVO;

public class DothingServiceImpl implements DothingService{
	private DothingDao dothingdao=new DothingDaoImpl();
	
	@Override
	public Integer insert(Dothing bean) {
		// TODO Auto-generated method stub
		return dothingdao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return dothingdao.delete(id);
	}

	@Override
	public Integer update(Dothing bean) {
		// TODO Auto-generated method stub
		return dothingdao.update(bean);
	}

	@Override
	public List<Dothing> list() {
		// TODO Auto-generated method stub
		return dothingdao.list();
	}

	@Override
	public Dothing load(Integer id) {
		// TODO Auto-generated method stub
		return dothingdao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return dothingdao.count();
	}

	@Override
	public Dothing loadByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.countByName(name);
	}

	@Override
	public Dothing loadByNo(String no) {
		// TODO Auto-generated method stub
		return dothingdao.loadByNo(no);
	}

	@Override
	public List<Dothing> listByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.listByName(name);
	}

	@Override
	public List<Dothing> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return dothingdao.queryAll(page);
	}

	@Override
	public Dothing getDothing(Dothing stu) {
		// TODO Auto-generated method stub
		return dothingdao.getDothing(stu);
	}

}
