package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.Dept;
import com.oaoffice.dao.DeptDao;
import com.oaoffice.dao.impl.DeptDaoImpl;
import com.oaoffice.service.DeptService;
import com.oaoffice.util.PagingVO;

public class DeptServiceImpl implements DeptService{
	DeptDao deptDao=new DeptDaoImpl();

	@Override
	public Integer insert(Dept bean) {
		// TODO Auto-generated method stub
		return deptDao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.delete(id);
	}

	@Override
	public Integer update(Dept bean) {
		// TODO Auto-generated method stub
		return deptDao.update(bean);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.list();
	}

	@Override
	public Dept load(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return deptDao.count();
	}

	@Override
	public Dept loadByName(String name) {
		// TODO Auto-generated method stub
		return deptDao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return deptDao.countByName(name);
	}

	@Override
	public Dept loadByNo(String no) {
		// TODO Auto-generated method stub
		return deptDao.loadByNo(no);
	}

	@Override
	public List<Dept> listByName(String name) {
		// TODO Auto-generated method stub
		return deptDao.listByName(name);
	}

	@Override
	public List<Dept> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return deptDao.queryAll(page);
	}

	@Override
	public Dept getDept(Dept stu) {
		// TODO Auto-generated method stub
		return deptDao.getDept(stu);
	}

}
