package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Vacate;
import com.oaoffice.dao.VacateDao;
import com.oaoffice.dao.impl.VacateDaoImpl;
import com.oaoffice.service.VacateService;
import com.oaoffice.util.PagingVO;

public class VacateServiceImpl implements VacateService{
	private VacateDao vacatedao=new VacateDaoImpl();
	
	@Override
	public Integer insert(Vacate bean) {
		// TODO Auto-generated method stub
		return vacatedao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return vacatedao.delete(id);
	}

	@Override
	public Integer update(Vacate bean) {
		// TODO Auto-generated method stub
		return vacatedao.update(bean);
	}

	@Override
	public List<Vacate> list() {
		// TODO Auto-generated method stub
		return vacatedao.list();
	}

	@Override
	public Vacate load(Integer id) {
		// TODO Auto-generated method stub
		return vacatedao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return vacatedao.count();
	}

	@Override
	public Vacate loadByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.countByName(name);
	}

	@Override
	public Vacate loadByNo(String no) {
		// TODO Auto-generated method stub
		return vacatedao.loadByNo(no);
	}

	@Override
	public List<Vacate> listByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.listByName(name);
	}

	@Override
	public List<Vacate> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return vacatedao.queryAll(page);
	}

	@Override
	public Vacate getVacate(Vacate stu) {
		// TODO Auto-generated method stub
		return vacatedao.getVacate(stu);
	}

}
