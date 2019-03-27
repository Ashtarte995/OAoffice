package com.oaoffice.dao;

import java.util.List;

import com.oaoffice.bean.*;

public interface PowerDao {

	List<Power> list();// 返回所有行的数据

	User_Role loadByid(String id);

	List<Role> listByRole();

	Integer updete(User_Role bean);

	List<Power_Role> listPower_Role(String id);

	List<Power_Role> listPower();

	Integer delete(String role_id, String power_id);
	
	Integer insert(String role_id, String power_id);
	
	List<Power> search(String str);
}
