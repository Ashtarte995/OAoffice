package com.oaoffice.service;

import java.util.List;

import com.oaoffice.bean.Power;

public interface PowerService {
	// 根据用户获取权限
	public List<Power> getPower(String uname);

	List<Power> list();// 返回所有行的数据
}
