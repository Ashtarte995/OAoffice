package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Bulletin;
import com.oaoffice.dao.BulletinDao;
import com.oaoffice.dao.impl.BulletinDaoImpl;
import com.oaoffice.service.BulletinService;
import com.oaoffice.util.PagingVO;

public class BulletinServiceImpl implements BulletinService{
	private BulletinDao bulletindao=new BulletinDaoImpl();
	
	@Override
	public Integer insert(Bulletin bean) {
		// TODO Auto-generated method stub
		return bulletindao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return bulletindao.delete(id);
	}

	@Override
	public Integer update(Bulletin bean) {
		// TODO Auto-generated method stub
		return bulletindao.update(bean);
	}

	@Override
	public List<Bulletin> list() {
		// TODO Auto-generated method stub
		return bulletindao.list();
	}

	@Override
	public Bulletin load(Integer id) {
		// TODO Auto-generated method stub
		return bulletindao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return bulletindao.count();
	}

	@Override
	public Bulletin loadByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.countByName(name);
	}

	@Override
	public Bulletin loadByNo(String no) {
		// TODO Auto-generated method stub
		return bulletindao.loadByNo(no);
	}

	@Override
	public List<Bulletin> listByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.listByName(name);
	}

	@Override
	public List<Bulletin> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return bulletindao.queryAll(page);
	}

	@Override
	public Bulletin getBulletin(Bulletin stu) {
		// TODO Auto-generated method stub
		return bulletindao.getBulletin(stu);
	}

}
