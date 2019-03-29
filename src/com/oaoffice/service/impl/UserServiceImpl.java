package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.User;
import com.oaoffice.dao.UserDao;
import com.oaoffice.dao.impl.UserDaoImpl;
import com.oaoffice.service.UserService;
import com.oaoffice.util.PagingVO;

public class UserServiceImpl implements UserService{
	private UserDao userdao=new UserDaoImpl();
	
	@Override
	public Integer insert(User bean) {
		// TODO Auto-generated method stub
		return userdao.insert(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userdao.delete(id);
	}

	@Override
	public Integer update(User bean) {
		// TODO Auto-generated method stub
		return userdao.update(bean);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userdao.list();
	}

	@Override
	public User load(Integer id) {
		// TODO Auto-generated method stub
		return userdao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return userdao.count();
	}

	@Override
	public User loadByName(String name) {
		// TODO Auto-generated method stub
		return userdao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return userdao.countByName(name);
	}

	@Override
	public User loadByNo(String no) {
		// TODO Auto-generated method stub
		return userdao.loadByNo(no);
	}

	@Override
	public List<User> listByName(String name) {
		// TODO Auto-generated method stub
		return userdao.listByName(name);
	}

	@Override
	public List<User> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return userdao.queryAll(page);
	}

	@Override
	public User getUser(User stu) {
		// TODO Auto-generated method stub
		return userdao.getUser(stu);
	}

	@Override
	public boolean checkUser(String uname) {
		User stu=new User();
		stu.setUser_name(uname);
		User s=userdao.getUser(stu);
		if(s!=null) {
			return true;
		}else {
			return false;
		}
		
	}
}


