package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.Power;
import com.oaoffice.dao.*;
import com.oaoffice.dao.impl.*;
import com.oaoffice.service.*;

public class PowerServiceImpl implements PowerService {
    PowerDao powerDao=new PowerDaoImpl();
	@Override
	public List<Power> getPower(String uname) {
		// TODO Auto-generated method stub
		return powerDao.getPower(uname);
	}
	@Override
	public List<Power> list() {
		// TODO Auto-generated method stub
		return powerDao.list();
	}

}
