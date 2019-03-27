package com.oaoffice.dao;

import java.util.List;

import com.oaoffice.bean.Power;


public interface PowerDao {
	//根据用户获取权限
		public List<Power> getPower(String uname);
		
	   List<Power> list();// 返回所有行的数据
}
