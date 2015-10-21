package com.frank.impl;

import java.util.List;

import com.frank.model.User;

public interface UserDAOImpl {

	// property constants
	public static final String NAME = "name";
	public static final String ROLE_ID = "roleId";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List<User> findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<User> findByName(Object name);

	public abstract List<User> findByRoleId(Object roleId);

	public abstract List<User> findByPassword(Object password);

	public abstract List<User> findByPhone(Object phone);

	public abstract List<User> findByEmail(Object email);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}