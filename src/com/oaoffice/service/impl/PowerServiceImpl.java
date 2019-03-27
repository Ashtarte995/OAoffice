package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.Power;
import com.oaoffice.bean.Power_Role;
import com.oaoffice.bean.Role;
import com.oaoffice.bean.User_Role;
import com.oaoffice.dao.PowerDao;
import com.oaoffice.dao.impl.PowerDaoImpl;
import com.oaoffice.service.PowerService;

public class PowerServiceImpl implements PowerService {
	PowerDao powerDao = new PowerDaoImpl();

	@Override
	public List<Power> list() {
		// TODO Auto-generated method stub
		return powerDao.list();
	}

	@Override
	public User_Role loadByid(String id) {

		return powerDao.loadByid(id);
	}

	@Override
	public List<Role> listByRole() {
		// TODO Auto-generated method stub
		return powerDao.listByRole();
	}

	@Override
	public Integer updete(User_Role bean) {
		// TODO Auto-generated method stub
		return powerDao.updete(bean);
	}

	@Override
	public List<Power_Role> listPower_Role(String id) {
		// TODO Auto-generated method stub
		return powerDao.listPower_Role(id);
	}

	@Override
	public List<Power_Role> listPower() {
		// TODO Auto-generated method stub
		return powerDao.listPower();
	}

	@Override
	public Integer delete(String role_id, String power_id) {
		// TODO Auto-generated method stub
		return powerDao.delete(role_id, power_id);
	}

	@Override
	public boolean insert(String role_id, String power_id) {
		List<Power_Role> list = powerDao.listPower_Role(role_id);
		for (Power_Role key : list) {
			if (power_id.equals(key.getPower_id())) {
				return false;
			} else {
				powerDao.insert(role_id, power_id);
				return true;
			}
		}
		return false;
	}

}
