package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Floder;
import com.oaoffice.dao.FloderDao;
import com.oaoffice.dao.impl.FloderDaoImpl;
import com.oaoffice.service.FloderService;
import com.oaoffice.util.PagingVO;

public class FloderServiceImpl implements FloderService{
	private FloderDao floderdao=new FloderDaoImpl();
	
	@Override
	public Integer insert(Floder bean) {
		// TODO Auto-generated method stub
		return floderdao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return floderdao.delete(id);
	}

	@Override
	public Integer update(Floder bean) {
		// TODO Auto-generated method stub
		return floderdao.update(bean);
	}

	@Override
	public List<Floder> list() {
		// TODO Auto-generated method stub
		return floderdao.list();
	}

	@Override
	public Floder load(Integer id) {
		// TODO Auto-generated method stub
		return floderdao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return floderdao.count();
	}

	@Override
	public Floder loadByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.countByName(name);
	}

	@Override
	public Floder loadByNo(String no) {
		// TODO Auto-generated method stub
		return floderdao.loadByNo(no);
	}

	@Override
	public List<Floder> listByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.listByName(name);
	}

	@Override
	public List<Floder> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return floderdao.queryAll(page);
	}

	@Override
	public Floder getFloder(Floder stu) {
		// TODO Auto-generated method stub
		return floderdao.getFloder(stu);
	}

}
