package com.demo.jmxweb.service;

import com.demo.jmxweb.dao.IDao;

public class ServiceImpl implements IService {

	private IDao dao;
	
	public void serviceHello(String name) {
		System.out.println(dao.sayHello(name));
	}
	public void serviceBye(String name){
		System.out.println(dao.sayBye(name));
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
