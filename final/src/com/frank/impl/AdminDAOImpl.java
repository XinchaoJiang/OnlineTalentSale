package com.frank.impl;

import java.util.List;

import com.frank.model.Admin;

public interface AdminDAOImpl {

	// property constants
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String ROLE_ID = "roleId";

	public abstract void save(Admin transientInstance);

	public abstract void delete(Admin persistentInstance);

	public abstract Admin findById(java.lang.Integer id);

	public abstract List<Admin> findByExample(Admin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Admin> findByAccount(Object account);

	public abstract List<Admin> findByPassword(Object password);

	public abstract List<Admin> findByRoleId(Object roleId);

	public abstract List findAll();

	public abstract Admin merge(Admin detachedInstance);

	public abstract void attachDirty(Admin instance);

	public abstract void attachClean(Admin instance);

}